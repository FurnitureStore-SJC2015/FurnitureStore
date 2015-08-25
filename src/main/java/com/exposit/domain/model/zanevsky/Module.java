package com.exposit.domain.model.zanevsky;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;

@SuppressWarnings("restriction")
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

	@Column(name = "cost")
	private double cost;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "image")
	@Lob
	private byte[] image;

	@ManyToMany(mappedBy = "modules")
	private List<Provider> providers;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storage_module_unit_id", nullable = true)
	private StorageModuleUnit storageModuleUnit;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module",
			cascade = CascadeType.ALL)
	private List<ProductTemplate> productTemplates;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module",
			cascade = CascadeType.ALL)
	private List<ShipmentUnit> shipmentUnits;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module",
			cascade = CascadeType.ALL)
	private List<RequestUnit> requestUnits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setProvider(List<Provider> providers) {
		this.providers = providers;
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

	public List<RequestUnit> getRequestUnits() {
		return requestUnits;
	}

	public void setRequestUnits(List<RequestUnit> requestUnits) {
		this.requestUnits = requestUnits;
	}

	public List<ShipmentUnit> getShipmentUnits() {
		return shipmentUnits;
	}

	public void setShipmentUnits(List<ShipmentUnit> shipmentUnits) {
		this.shipmentUnits = shipmentUnits;
	}

	public String getImage() {
		return Base64.encode(image);
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
