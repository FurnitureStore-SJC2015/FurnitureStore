package com.exposit.model;

public class CommodityTemplate {
	private Integer id;
	private Module module;
	private Integer count;
	private CommodityCatalogUnit commodityCatalogUnit;

	public CommodityCatalogUnit getCommodityCatalogUnit() {
		return commodityCatalogUnit;
	}

	public void setCommodityCatalogUnit(
			CommodityCatalogUnit commodityCatalogUnit) {
		this.commodityCatalogUnit = commodityCatalogUnit;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
