package com.exposit.repository.dao.dobrilko;

import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.base.GenericDao;

public interface StorageModuleUnitDao extends
		GenericDao<StorageModuleUnit, Integer> {

	public StorageModuleUnit getStorageModuleUnit(Module module);

	// public List<StorageModuleUnit> getStorageModuleUnits(
	// ProductCatalogUnit productCatalogUnit);
}
