package com.exposit.model;

import java.util.List;

public class Module {
	private int id;
	private Provider provider;
	private ModuleType moduleType;
	private StorageModuleUnit storageModuleUnit;
	private List<CommodityTemplate> commodityTemplate;

	public List<CommodityTemplate> getCommodityTemplate() {
		return commodityTemplate;
	}

	public void setCommodityTemplate(List<CommodityTemplate> commodityTemplate) {
		this.commodityTemplate = commodityTemplate;
	}

	public StorageModuleUnit getStorageModuleUnit() {
		return storageModuleUnit;
	}

	public void setStorageModuleUnit(StorageModuleUnit storageModuleUnit) {
		this.storageModuleUnit = storageModuleUnit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ModuleType getModuleType() {
		return moduleType;
	}

	public void setModuleType(ModuleType moduleType) {
		this.moduleType = moduleType;
	}

}
