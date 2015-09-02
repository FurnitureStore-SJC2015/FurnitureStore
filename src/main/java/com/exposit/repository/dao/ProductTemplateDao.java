package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ProductTemplate;
import com.exposit.repository.base.GenericDao;

public interface ProductTemplateDao extends GenericDao<ProductTemplate, Integer>{
	
	public List<ProductTemplate> getProductTemplatesList(ProductCatalogUnit catalogUnit);
	
	public List<ProductTemplate> getProductTemplatesList(Module module);
}
