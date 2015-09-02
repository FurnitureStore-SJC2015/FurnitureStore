package com.exposit.domain.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "feedback_id")
	private int id;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "text", length = 512, nullable = false)
	private String text;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "feedback_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "rating")
	private int range;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_catalog_unit_id", nullable = false)
	private ProductCatalogUnit productCatalogUnit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public ProductCatalogUnit getProductCatalogUnit() {
		return productCatalogUnit;
	}

	public void setProductCatalogUnit(ProductCatalogUnit productCatalogUnit) {
		this.productCatalogUnit = productCatalogUnit;
	}

}
