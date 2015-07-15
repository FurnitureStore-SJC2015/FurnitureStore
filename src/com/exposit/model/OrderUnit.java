package com.exposit.model;

public class OrderUnit {

	private int id;
	private CommodityCatalogUnit commodityCatalogUnit;
	private Order order;
	private boolean ready;
	private double cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CommodityCatalogUnit getCommodityCatalogUnit() {
		return commodityCatalogUnit;
	}
	public void setCommodityCatalogUnit(CommodityCatalogUnit commodityCatalogUnit) {
		this.commodityCatalogUnit = commodityCatalogUnit;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}


}
