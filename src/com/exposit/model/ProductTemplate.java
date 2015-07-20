package com.exposit.model;

public class ProductTemplate {
	private int id;
	private Module module;
	private int count;
	private ProductCatalogUnit commodityCatalogUnit;

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

	public ProductCatalogUnit getCommodityCatalogUnit() {
		return commodityCatalogUnit;
	}

	public void setCommodityCatalogUnit(
			ProductCatalogUnit commodityCatalogUnit) {
		this.commodityCatalogUnit = commodityCatalogUnit;
	}

}
