package com.exposit.domain.model.zanevsky;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;

@Entity
@Table(name = "module")
public class Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "module_id")
	private int id;	
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "module_type")
	@Enumerated(EnumType.STRING)
	private ModuleType moduleType;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Provider provider;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "module_id", nullable = true)
//	private StorageModuleUnit storageModuleUnit;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable = false)
	private List<ProductTemplate> productTemplates;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "module_id", nullable = false)
//	private List<ShipmentUnit> shipmentUnits;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = )
//	private List<RequestUnit> requestUnit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Provider getProvider() {
//		return provider;
//	}
//
//	public void setProvider(Provider provider) {
//		this.provider = provider;
//	}

	public ModuleType getModuleType() {
		return moduleType;
	}

	public void setModuleType(ModuleType moduleType) {
		this.moduleType = moduleType;
	}

//	public StorageModuleUnit getStorageModuleUnit() {
//		return storageModuleUnit;
//	}
//
//	public void setStorageModuleUnit(StorageModuleUnit storageModuleUnit) {
//		this.storageModuleUnit = storageModuleUnit;
//	}

	public List<ProductTemplate> getProductTemplates() {
		return productTemplates;
	}

	public void setProductTemplates(List<ProductTemplate> productTemplates) {
		this.productTemplates = productTemplates;
	}

//	public List<ShipmentUnit> getShipmentUnits() {
//		return shipmentUnits;
//	}
//
//	public void setShipmentUnits(List<ShipmentUnit> shipmentUnits) {
//		this.shipmentUnits = shipmentUnits;
//	}

//	public RequestUnit getRequestUnit() {
//		return requestUnit;
//	}
//
//	public void setRequestUnit(RequestUnit requestUnit) {
//		this.requestUnit = requestUnit;
//	}

}
