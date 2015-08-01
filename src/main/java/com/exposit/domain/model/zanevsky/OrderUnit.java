package com.exposit.domain.model.zanevsky;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.exposit.domain.model.sorokin.Order;

@Entity
@Table(name = "order_unit")
public class OrderUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "order_unit_id")
	private int id;
	
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "order_unit_cost", scale = 2, nullable = false)
	private double cost;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Status status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private ProductCatalogUnit productCatalogUnit;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Order order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductCatalogUnit getProductCatalogUnit() {
		return productCatalogUnit;
	}

	public void setProductCatalogUnit(ProductCatalogUnit productCatalogUnit) {
		this.productCatalogUnit = productCatalogUnit;
	}

//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
