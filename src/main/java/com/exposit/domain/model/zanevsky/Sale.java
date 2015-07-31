package com.exposit.domain.model.zanevsky;

import java.util.Date;
import java.util.List;

public class Sale {

	private int id;
	private Date startTime;
	private Date endTime;
	private double percentageSale;
	private List<ProductCatalogUnit> productCatalogUnits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getPercentageSale() {
		return percentageSale;
	}

	public void setPercentageSale(double percentageSale) {
		this.percentageSale = percentageSale;
	}

	public List<ProductCatalogUnit> getProductCatalogUnits() {
		return productCatalogUnits;
	}

	public void setProductCatalogUnits(
			List<ProductCatalogUnit> productCatalogUnits) {
		this.productCatalogUnits = productCatalogUnits;
	}

}
