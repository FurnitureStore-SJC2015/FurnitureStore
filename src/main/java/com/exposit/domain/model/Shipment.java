package com.exposit.domain.model;

import java.util.List;

public class Shipment {

	private int id;
	// Coefficient
	private double marginRate;
	private Waybill waybill;
	private Provider provider;
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

	public double getMarginRate() {
		return marginRate;
	}

	public void setMarginRate(double marginRate) {
		this.marginRate = marginRate;
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
