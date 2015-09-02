package com.exposit.domain.service;

import java.util.HashMap;
import java.util.List;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ProductTemplate;
import com.exposit.domain.model.Provider;
import com.exposit.domain.model.RequestUnit;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.web.dto.ModuleDto;

public interface ModuleService {

	public Module findById(int id);

	public List<Module> getModules(Provider provider);

	public List<Module> getModules(ProductCatalogUnit productCatalogUnit);

	public Module getModule(ShipmentUnit shipmentUnit);

	public Module getModule(RequestUnit requestUnit);

	public Module getModule(StorageModuleUnit storageModuleUnit);

	public Module getModule(ProductTemplate template);

	public void deleteModuleFromProviderList(Integer id, Provider provider);

	public HashMap<Module, Integer> getAbsentModulesInOrder(Order order);

	public HashMap<Module, Integer> getModulesInOrder(Order order);

	public Boolean isAllModulesPresented(Order order);

	public List<Module> findAll();

	public List<ModuleDto> getModulesByProvider(Provider provider);

	public void addModuleToProviderList(Integer id, Provider provider);

}
