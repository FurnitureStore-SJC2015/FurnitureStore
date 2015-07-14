package com.exposit.model;

import java.util.List;

public class Cargo {

	private int id;
	// Coefficient
	private double marginRate;
	private Report report;
	private Waybill waybill;
	private List<CargoUnit> cargoUnits;
	
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
	
	public Report getReport() {
		return report;
	}
	
	public void setReport(Report report) {
		this.report = report;
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
