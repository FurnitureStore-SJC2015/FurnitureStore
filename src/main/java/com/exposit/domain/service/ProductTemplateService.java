package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.Order;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ProductTemplate;

public interface ProductTemplateService {
	
	public List<ProductTemplate> getEmptyProductTemplatesList();
	
	public List<ProductTemplate> getProductTemplates(ProductCatalogUnit productCatalogUnit);
}
