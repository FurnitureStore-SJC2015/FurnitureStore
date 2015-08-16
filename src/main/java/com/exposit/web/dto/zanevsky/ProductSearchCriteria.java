package com.exposit.web.dto.zanevsky;

public class ProductSearchCriteria {
	
	private double minCost;
	
	private double maxCost;

	public ProductSearchCriteria(){
		this.minCost = 0;
		this.maxCost = Double.MAX_VALUE;
	}
	
	public ProductSearchCriteria(double minCost, double maxCost){
		this.minCost = minCost;
		this.maxCost = maxCost;
	}
	
	public double getMinCost() {
		return minCost;
	}

	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}

	public double getMaxCost() {
		return maxCost;
	}

	public void setMaxCost(double maxCost) {
		this.maxCost = maxCost;
	}
	
	
}
