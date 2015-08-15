package com.exposit.domain.model.sorokin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;

public class ShoppingCart {
	private List<ProductCatalogUnit> items;

	public ShoppingCart() {
		items = new ArrayList<ProductCatalogUnit>();
	}

	public List<ProductCatalogUnit> getItems() {
		return items;
	}

	public void setItems(List<ProductCatalogUnit> items) {
		this.items = items;
	}

}
