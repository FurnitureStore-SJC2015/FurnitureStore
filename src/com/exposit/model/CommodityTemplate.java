package com.exposit.model;

public class CommodityTemplate {
	private int id;
	private Module module;
	private int count;
	private CommodityCatalogUnit commodityCatalogUnit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CommodityCatalogUnit getCommodityCatalogUnit() {
		return commodityCatalogUnit;
	}

	public void setCommodityCatalogUnit(
			CommodityCatalogUnit commodityCatalogUnit) {
		this.commodityCatalogUnit = commodityCatalogUnit;
	}

}
