package com.exposit.repository.impl.zanevsky;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
		Criteria criteria = this.getSession().createCriteria(Sale.class, "sale")
				.createAlias("sale.productCatalogUnits", "product")
				.add(Restrictions.eq("product.id", catalogUnit.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Sale) criteria.uniqueResult();
	}

}
