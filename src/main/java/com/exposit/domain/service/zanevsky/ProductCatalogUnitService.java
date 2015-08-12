package com.exposit.domain.service.zanevsky;

import java.util.List;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;

public interface ProductCatalogUnitService {
	
	public List<ProductCatalogUnit> getAllProductCatalogUnits();
	
	public ProductCatalogUnit FindById(int id);
	
	public String processImage(ProductCatalogUnit product);
}
