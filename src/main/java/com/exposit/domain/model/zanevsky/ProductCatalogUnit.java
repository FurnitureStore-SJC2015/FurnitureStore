package com.exposit.domain.model.zanevsky;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Entity
@Table(name = "product_catalog_unit")
public class ProductCatalogUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "product_catalog_unit_id")
	private int id;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "product_cost", scale = 2, unique = true)
	private double cost;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "margin_coefficient", scale = 2)
	private double coefficient;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "product_name", length = 50)
	private String name;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "product_description")
	private String description;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "image")
	@Lob
	private byte[] image;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sale_id")
	private Sale sale;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productCatalogUnit",
			cascade = { CascadeType.REMOVE })
	private List<Feedback> feedbacks;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productCatalogUnit",
			cascade = CascadeType.ALL)
	private List<ProductTemplate> productTemplates;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productCatalogUnit",
			cascade = CascadeType.ALL)
	private List<OrderUnit> orderUnits;

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

	public String getImage() {
		return Base64.encode(image);
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
