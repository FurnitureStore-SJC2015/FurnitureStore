package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ProductTemplate;
import com.exposit.domain.model.Provider;
import com.exposit.domain.model.RequestUnit;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.repository.base.GenericDao;

public interface ModuleDao extends GenericDao<Module, Integer>{
	
	public List<Module> getModules(Provider provider);
	
	public List<Module> getModules(ProductCatalogUnit productCatalogUnit);
	
	public Module getModule(ShipmentUnit shipmentUnit);	

	public Module getModule(RequestUnit requestUnit);
	
	public Module getModule(StorageModuleUnit storageModuleUnit);
	
	public Module getModule(ProductTemplate template);
	
}
