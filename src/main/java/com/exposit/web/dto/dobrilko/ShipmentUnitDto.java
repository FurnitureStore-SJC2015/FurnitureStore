package com.exposit.web.dto.dobrilko;

public class ShipmentUnitDto {

	private int id;

	private int count;

	private String moduleName;

	private double moduleCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public double getModuleCost() {
		return moduleCost;
	}

	public void setModuleCost(double moduleCost) {
		this.moduleCost = moduleCost;
	}
}
