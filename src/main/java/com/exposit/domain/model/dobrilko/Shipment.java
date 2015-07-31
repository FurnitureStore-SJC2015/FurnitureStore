package com.exposit.domain.model.dobrilko;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shipment_id")
	private int id;
	@Column(name = "cargo_margin_coefficient")
	private double marginCoefficient;
	@OneToOne
	@JoinColumn(name = "way_bill_id")
	private Waybill waybill;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "provider_id", nullable = false)
	private Provider provider;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment",
			orphanRemoval = true)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private List<ShipmentUnit> shipmentUnits;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMarginCoefficient() {
		return marginCoefficient;
	}

	public void setMarginCoefficient(double marginCoefficient) {
		this.marginCoefficient = marginCoefficient;
	}

	public Waybill getWaybill() {
		return waybill;
	}

	public void setWaybill(Waybill waybill) {
		this.waybill = waybill;
	}

	public List<ShipmentUnit> getShipmentUnits() {
		return shipmentUnits;
	}

	public void setShipmentUnits(List<ShipmentUnit> shipmentUnits) {
		this.shipmentUnits = shipmentUnits;
	}

}
