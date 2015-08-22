package com.exposit.web.dto.zanevsky;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;

public class ProductDto {
	private double range;
	private ProductCatalogUnit product;

	public ProductDto(ProductCatalogUnit product, Double range) {
		this.product = product;
		this.range = range;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public ProductCatalogUnit getProduct() {
		return product;
	}

	public void setProduct(ProductCatalogUnit product) {
		this.product = product;
	}

}
