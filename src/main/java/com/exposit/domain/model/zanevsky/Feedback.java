package com.exposit.domain.model.zanevsky;

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

import com.exposit.domain.model.sorokin.User;

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
	@Enumerated(EnumType.ORDINAL)
	private RangeType range;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_catalog_unit_id", nullable = false)
	private ProductCatalogUnit productCatalogUnit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public RangeType getRange() {
		return range;
	}

	public void setRange(RangeType range) {
		this.range = range;
	}

	public ProductCatalogUnit getProductCatalogUnit() {
		return productCatalogUnit;
	}

	public void setProductCatalogUnit(ProductCatalogUnit productCatalogUnit) {
		this.productCatalogUnit = productCatalogUnit;
	}

}
