package com.exposit.repository.impl.zanevsky;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

public class ProductCatalogUnitRepository
		extends AbstractHibernateDao<ProductCatalogUnit, Integer>
		implements ProductCatalogUnitDao {
	
}
