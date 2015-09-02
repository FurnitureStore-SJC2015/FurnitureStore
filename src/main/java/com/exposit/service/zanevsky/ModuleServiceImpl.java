package com.exposit.service.zanevsky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.service.dobrilko.StorageModuleUnitService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.ModuleService;
import com.exposit.domain.service.zanevsky.OrderUnitService;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.domain.service.zanevsky.ProductTemplateService;
import com.exposit.repository.dao.dobrilko.ProviderDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.web.dto.dobrilko.ModuleDto;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDao moduleRepository;

	@Autowired
	private ProviderDao providerRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderUnitService orderUnitService;
	@Autowired
	private ProductCatalogUnitService productCatalogUnitService;
	@Autowired
	private ProductTemplateService productTemplateService;

	@Autowired
	StorageModuleUnitService storageModuleUnitService;

	@Override
	public List<Module> findAll() {
		return moduleRepository.findAll();
	}

	@Override
	public Module findById(int id) {
		return this.moduleRepository.findById(id);
	}

	@Override
	public List<ModuleDto> getModulesByProvider(Provider provider) {
		List<ModuleDto> modules = new ArrayList<ModuleDto>();

		for (Module module : this.findAll()) {
			if (!this.getModules(provider).contains(module)) {
				ModuleDto moduleDto = new ModuleDto();
				moduleDto.setId(module.getId());
				moduleDto.setName(module.getModuleType().toString());
				modules.add(moduleDto);
			}

		}
		return modules;
	}

	@Override
	public List<Module> getModules(Provider provider) {
		return this.moduleRepository.getModules(providerRepository
				.findById(provider.getId()));
	}

	@Override
	public List<Module> getModules(ProductCatalogUnit productCatalogUnit) {
		return this.moduleRepository.getModules(productCatalogUnit);
	}

	@Override
	public Module getModule(ShipmentUnit shipmentUnit) {
		return this.moduleRepository.getModule(shipmentUnit);
	}

	@Override
	public Module getModule(RequestUnit requestUnit) {
		return this.moduleRepository.getModule(requestUnit);
	}

	@Override
	public Module getModule(StorageModuleUnit storageModuleUnit) {
		return this.moduleRepository.getModule(storageModuleUnit);
	}

	@Override
	public Module getModule(ProductTemplate template) {
		return this.moduleRepository.getModule(template);
	}

	@Transactional
	@Override
	public void deleteModuleFromProviderList(Integer id, Provider provider) {

		Module module = this.findById(id);
		Provider pr = providerRepository.findById(provider.getId());
		List<Module> modules = this.getModules(pr);

		List<Provider> providers = providerRepository.getProviders(module);

		modules.remove(module);

		providers.remove(pr);

		module.setProvider(providers);
		pr.setModules(modules);

		providerRepository.update(pr);
		moduleRepository.update(module);

		return;
	}

	@Override
	public HashMap<Module, Integer> getAbsentModulesInOrder(Order order) {
		HashMap<Module, Integer> orderModuleMap = this.getModulesInOrder(order);
		HashMap<Module, Integer> absentModuleMap = new HashMap<Module, Integer>();
		for (Module module : orderModuleMap.keySet()) {
			int orderModuleCount = orderModuleMap.get(module);
			int storageModuleCount = module.getStorageModuleUnit().getCount();
			if (orderModuleCount > storageModuleCount) {
				absentModuleMap.put(module, orderModuleCount
						- storageModuleCount);
			} else
				continue;
		}
		return absentModuleMap;
	}

	@Override
	public HashMap<Module, Integer> getModulesInOrder(Order order) {
		HashMap<Module, Integer> modules = new HashMap<Module, Integer>();
		for (ProductCatalogUnit product : productCatalogUnitService
				.getProducts(order)) {
			for (ProductTemplate template : productTemplateService
					.getProductTemplates(product)) {
				Module oneModule = this.getModule(template);
				if (modules.containsKey(oneModule)) {
					int modulesCount = modules.get(oneModule);
					modulesCount += template.getCount();
					modules.put(oneModule, modulesCount);
				} else
					modules.put(oneModule, template.getCount());
			}
		}

		return modules;
	}

	@Override
	public Boolean isAllModulesPresented(Order order) {
		if (this.getAbsentModulesInOrder(order).size() != 0)
			return false;
		else
			return true;

	}

	@Override
	public void addModuleToProviderList(Integer id, Provider provider) {
		Module module = this.findById(id);
		Provider pr = providerRepository.findById(provider.getId());
		List<Module> modules = this.getModules(pr);

		List<Provider> providers = providerRepository.getProviders(module);

		modules.add(module);

		providers.add(pr);

		module.setProvider(providers);
		pr.setModules(modules);

		providerRepository.update(pr);
		moduleRepository.update(module);

		return;
		
	}
}
