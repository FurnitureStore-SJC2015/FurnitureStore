package com.exposit.repository.dao.zanevsky;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.repository.base.GenericDao;

public interface SaleDao extends GenericDao<Sale, Integer> {
	
	public Sale getSale(ProductCatalogUnit catalogUnit);
	
	public boolean haveSale(ProductCatalogUnit catalogUnit);
}
