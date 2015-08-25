package com.exposit.service.zanevsky;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.ModuleService;
import com.exposit.repository.dao.dobrilko.ProviderDao;
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

	@Override
	public Module findById(int id) {
		return this.moduleDao.findById(id);
	}

	@Override
	public List<Module> getModules(Provider provider) {
		return this.moduleDao.getModules(provider);
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

		List<Module> modules = this.getModules(provider);

		Module module = this.findById(id);
		List<Provider> providers = providerDao.getProviders(module);

		modules.remove(module);
		providers.remove(provider);

		module.setProvider(providers);
		provider.setModules(modules);

		
		
		moduleDao.update(module);
		providerDao.update(provider);
		this.getModules(provider);
	}
}
