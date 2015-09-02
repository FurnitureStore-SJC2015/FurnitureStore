package com.exposit.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;
	private double totalPrice;
	private List<ProductCatalogUnit> items;

	public ShoppingCart() {
		items = new ArrayList<ProductCatalogUnit>();
		totalPrice = 0;
	}

	public List<ProductCatalogUnit> getItems() {
		return items;
	}

	public void setItems(List<ProductCatalogUnit> items) {
		this.items = items;
	}

	public Integer getSize() {
		return items.size();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice= totalPrice;
	}

}
