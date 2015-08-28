package com.exposit.domain.service.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.web.dto.dobrilko.StorageModuleUnitDto;

public interface StorageModuleUnitService {

	public List<StorageModuleUnit> getStorageModuleUnits();

	public StorageModuleUnit getStorageModuleUnitById(Integer id);

	public List<StorageModuleUnitDto> getStorageModuleUnitDtos();

	public StorageModuleUnit getStorageModuleUnit(Module module);

	public void update(StorageModuleUnit storageModuleUnit);

	public void addModulesInStorage(Shipment shipment);

}
