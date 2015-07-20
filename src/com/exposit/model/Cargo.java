package com.exposit.model;

import java.util.List;

public class Cargo {

	private int id;
	// Coefficient
	private double marginRate;
	private Waybill waybill;
	private Provider provider;
	private List<CargoUnit> cargoUnits;

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

	public List<CargoUnit> getCargoUnits() {
		return cargoUnits;
	}

	public void setCargoUnits(List<CargoUnit> cargoUnits) {
		this.cargoUnits = cargoUnits;
	}
}
