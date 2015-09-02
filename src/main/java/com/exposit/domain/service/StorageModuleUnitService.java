package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.web.dto.StorageModuleUnitDto;

public interface StorageModuleUnitService {

	public List<StorageModuleUnit> getStorageModuleUnits();

	public StorageModuleUnit getStorageModuleUnitById(Integer id);

	public List<StorageModuleUnitDto> getStorageModuleUnitDtos();

	public StorageModuleUnit getStorageModuleUnit(Module module);

	public void update(StorageModuleUnit storageModuleUnit);

	public void addModulesInStorage(Shipment shipment);
	
	public void holdModulesWhileConfirmOrder(Order order);

}
