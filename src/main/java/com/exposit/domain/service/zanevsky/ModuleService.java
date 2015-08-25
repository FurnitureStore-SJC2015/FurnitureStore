package com.exposit.domain.service.zanevsky;

import java.util.List;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;

public interface ModuleService {
	
	public Module findById(int id);
	
	public List<Module> getModules(Provider provider);
	
	public List<Module> getModules(ProductCatalogUnit productCatalogUnit);
	
	public Module getModule(ShipmentUnit shipmentUnit);	

	public Module getModule(RequestUnit requestUnit);
	
	public Module getModule(StorageModuleUnit storageModuleUnit);
	
	public Module getModule(ProductTemplate template);
	
	public void deleteModuleFromProviderList(Integer id, Provider provider);
}
