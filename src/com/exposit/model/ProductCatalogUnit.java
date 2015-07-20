package com.exposit.model;

import java.util.List;

public class ProductCatalogUnit {
	private int id;
	private double cost;
	private double coefficient;
	private List<Feedback> feedbacks;
	private Sale sale;
	private List<ProductTemplate> productTemplates;
	private List<OrderUnit> orderUnits;
	private String name;

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

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public List<ProductTemplate> getProductTemplates() {
		return productTemplates;
	}

	public void setProductTemplates(List<ProductTemplate> productTemplates) {
		this.productTemplates = productTemplates;
	}

	public List<OrderUnit> getOrderUnits() {
		return orderUnits;
	}

	public void setOrderUnits(List<OrderUnit> orderUnits) {
		this.orderUnits = orderUnits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
