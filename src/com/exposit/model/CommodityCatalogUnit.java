package com.exposit.model;

import java.util.List;

public class CommodityCatalogUnit {
	private int id;
	private double cost;
	private double coefficient;
	private List<Feedback> feedbacks;
	private List<CommodityTemplate> commodityTemplates;
	private List<OrderUnit> orderUnits;
	private String name;
	
	
	public List<OrderUnit> getOrderUnits() {
		return orderUnits;
	}

	public void setOrderUnits(List<OrderUnit> orderUnits) {
		this.orderUnits = orderUnits;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
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
