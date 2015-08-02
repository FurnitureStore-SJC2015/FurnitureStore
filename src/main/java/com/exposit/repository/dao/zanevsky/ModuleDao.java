package com.exposit.repository.dao.zanevsky;

import java.util.List;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.repository.base.GenericDao;

public interface ModuleDao extends GenericDao<Module, Integer>{
	
	public List<Module> getModules(Provider provider);
	
	public List<Module> getModules(ProductCatalogUnit productCatalogUnit);
	
	public Module getModule(StorageModuleUnit storageModuleUnit);
	
	public Module getModule(ProductTemplate template);
	
	public Module getModule(ShipmentUnit shipmentUnit);
}
