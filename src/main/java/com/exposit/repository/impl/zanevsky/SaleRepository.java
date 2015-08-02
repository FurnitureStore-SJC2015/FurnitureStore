package com.exposit.repository.impl.zanevsky;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.repository.dao.zanevsky.SaleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class SaleRepository extends AbstractHibernateDao<Sale, Integer>
		implements SaleDao {

	@Override
	public Sale getSale(ProductCatalogUnit catalogUnit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean haveSale(ProductCatalogUnit catalogUnit) {
		// TODO Auto-generated method stub
		return false;
	}

}
