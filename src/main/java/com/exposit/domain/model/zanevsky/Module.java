package com.exposit.domain.model.zanevsky;

import java.util.List;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;

public class Module {
	private int id;
	private Provider provider;
	private ModuleType moduleType;
	private StorageModuleUnit storageModuleUnit;
	private List<ProductTemplate> productTemplates;
	private List<ShipmentUnit> shipmentUnits;
	private RequestUnit requestUnit;

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

	public StorageModuleUnit getStorageModuleUnit() {
		return storageModuleUnit;
	}

	public void setStorageModuleUnit(StorageModuleUnit storageModuleUnit) {
		this.storageModuleUnit = storageModuleUnit;
	}

	public List<ProductTemplate> getProductTemplates() {
		return productTemplates;
	}

	public void setProductTemplates(List<ProductTemplate> productTemplates) {
		this.productTemplates = productTemplates;
	}

	public List<ShipmentUnit> getShipmentUnits() {
		return shipmentUnits;
	}

	public void setShipmentUnits(List<ShipmentUnit> shipmentUnits) {
		this.shipmentUnits = shipmentUnits;
	}

	public RequestUnit getRequestUnit() {
		return requestUnit;
	}

	public void setRequestUnit(RequestUnit requestUnit) {
		this.requestUnit = requestUnit;
	}

}
