package com.exposit.service.zanevsky;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.service.dobrilko.StorageModuleUnitService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.ModuleService;
import com.exposit.domain.service.zanevsky.OrderUnitService;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.domain.service.zanevsky.ProductTemplateService;
import com.exposit.repository.dao.dobrilko.ProviderDao;
import com.exposit.repository.dao.dobrilko.StorageModuleUnitDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleDao moduleDao;
	@Autowired
	ProviderDao providerDao;
	@Autowired
	UserService userService;
	@Autowired
	OrderUnitService orderUnitService;
	@Autowired
	ProductCatalogUnitService productCatalogUnitService;
	@Autowired
	ProductTemplateService productTemplateService;

	@Autowired
	StorageModuleUnitService storageModuleUnitService;

	@Override
	public Module findById(int id) {
		return this.moduleDao.findById(id);
	}

	@Override
	public List<Module> getModules(Provider provider) {
		return this.moduleDao
				.getModules(providerDao.findById(provider.getId()));
	}

	@Override
	public List<Module> getModules(ProductCatalogUnit productCatalogUnit) {
		return this.moduleDao.getModules(productCatalogUnit);
	}

	@Override
	public Module getModule(ShipmentUnit shipmentUnit) {
		return this.moduleDao.getModule(shipmentUnit);
	}

	@Override
	public Module getModule(RequestUnit requestUnit) {
		return this.moduleDao.getModule(requestUnit);
	}

	@Override
	public Module getModule(StorageModuleUnit storageModuleUnit) {
		return this.moduleDao.getModule(storageModuleUnit);
	}

	@Override
	public Module getModule(ProductTemplate template) {
		return this.moduleDao.getModule(template);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void deleteModuleFromProviderList(Integer id, Provider provider) {

		Module module = this.findById(id);
		Provider pr = providerDao.findById(provider.getId());
		List<Module> modules = this.getModules(pr);

		List<Provider> providers = providerDao.getProviders(module);

		modules.remove(module);

		providers.remove(pr);

		module.setProvider(providers);
		pr.setModules(modules);

		providerDao.update(pr);
		moduleDao.update(module);

		List<Provider> prs = providerDao.getProviders(module);
		List<Module> mdls = moduleDao.getModules(pr);

		return;
	}

	@Transactional
	@Override
	public List<ProductTemplate> getAbsentProductTemplates(Order order) {

		List<ProductTemplate> productTemplates = new ArrayList<ProductTemplate>();

		List<ProductCatalogUnit> catalogUnits = productCatalogUnitService
				.getProducts(order);
		for (ProductCatalogUnit productCatalogUnit : catalogUnits) {
			for (ProductTemplate productTemplate : productTemplateService
					.getProductTemplates(productCatalogUnit)) {
				if (storageModuleUnitService.getStorageModuleUnit(
						this.getModule(productTemplate)).getCount() == 0) {
					productTemplates.add(productTemplate);
				}

			}
		}
		return productTemplates;

	}
}
