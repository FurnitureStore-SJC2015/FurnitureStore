package com.exposit.domain.model.zanevsky;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "sale_id")
	private int id;
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "start_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "end_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "percentage_sale", nullable = false, scale = 2)
	private double percentageSale;
	
	private List<ProductCatalogUnit> productCatalogUnits;

	public Sale(){
		
	}
	
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
