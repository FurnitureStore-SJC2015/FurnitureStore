package com.exposit.repository.dao;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.repository.base.GenericDao;

public interface StorageModuleUnitDao extends
		GenericDao<StorageModuleUnit, Integer> {

	public StorageModuleUnit getStorageModuleUnit(Module module);

	// public List<StorageModuleUnit> getStorageModuleUnits(
	// ProductCatalogUnit productCatalogUnit);
}
