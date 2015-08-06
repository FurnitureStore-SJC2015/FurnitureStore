package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.repository.dao.zanevsky.ProductTemplateDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ProductTemplateRepository
		extends AbstractHibernateDao<ProductTemplate, Integer>
		implements ProductTemplateDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductTemplate> getProductTemplatesList(
			ProductCatalogUnit catalogUnit) {
		Criteria criteria = this.getSession().createCriteria(ProductTemplate.class, "template")
				.add(Restrictions.eq("productCatalogUnit", catalogUnit));
		return (List<ProductTemplate>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductTemplate> getProductTemplatesList(Module module) {
		Criteria criteria = this.getSession().createCriteria(ProductTemplate.class, "template")
				.add(Restrictions.eq("module", module));
		return (List<ProductTemplate>) criteria.list();
	}
	
}
