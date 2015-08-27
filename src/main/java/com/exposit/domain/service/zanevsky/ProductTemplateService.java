package com.exposit.domain.service.zanevsky;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;

public interface ProductTemplateService {
	
	public List<ProductTemplate> getEmptyProductTemplatesList();
	
	public List<ProductTemplate> getProductTemplates(ProductCatalogUnit productCatalogUnit);
}
