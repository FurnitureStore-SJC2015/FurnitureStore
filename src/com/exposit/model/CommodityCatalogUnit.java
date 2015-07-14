package com.exposit.model;

import java.util.List;

public class CommodityCatalogUnit {
	private Integer id;
	private Double cost;
	private Double coefficient;
	private List<CommodityTemplate> commodityTemplates;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public List<CommodityTemplate> getCommodityTemplates() {
		return commodityTemplates;
	}

	public void setCommodityTemplates(List<CommodityTemplate> commodityTemplates) {
		this.commodityTemplates = commodityTemplates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
