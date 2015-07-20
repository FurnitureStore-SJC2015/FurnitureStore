package com.exposit.model;

import java.util.Date;

public class Feedback {
	private int id;
	private User user;
	private String text;
	private Date date;
	private RangeType range;
	private ProductCatalogUnit commodityCatalogUnit;

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

	public ProductCatalogUnit getCommodityCatalogUnit() {
		return commodityCatalogUnit;
	}

	public void setCommodityCatalogUnit(
			ProductCatalogUnit commodityCatalogUnit) {
		this.commodityCatalogUnit = commodityCatalogUnit;
	}

}
