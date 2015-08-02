package com.exposit.repository.dao.zanevsky;

import java.util.List;

import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.repository.base.GenericDao;

public interface ProductTemplateDao extends GenericDao<ProductTemplate, Integer>{
	
	public List<ProductTemplate> getProductTemlplatesList(ProductCatalogUnit catalogUnit);
	
	public ProductTemplate getProductTemplate(Module module);
}
