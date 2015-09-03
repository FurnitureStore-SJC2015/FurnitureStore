package com.exposit.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.Module;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.User;
import com.exposit.repository.dao.ProductCatalogUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ProductCatalogUnitRepository extends
		AbstractHibernateDao<ProductCatalogUnit, Integer> implements
		ProductCatalogUnitDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCatalogUnit> getProducts(Order order) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.createAlias("product.orderUnits", "unit")
				.add(Restrictions.eq("unit.order", order));
		return (List<ProductCatalogUnit>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCatalogUnit> getProducts(User user) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.createAlias("product.orderUnits", "unit")
				.createAlias("unit.order", "order")
				.add(Restrictions.eq("order.user", user))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<ProductCatalogUnit>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCatalogUnit> getProducts(Module module) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.createAlias("product.productTemplates", "template")
				.add(Restrictions.eq("template.module", module))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<ProductCatalogUnit>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCatalogUnit> lowerBound(double cost) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.add(Restrictions.lt("cost", cost));
		return (List<ProductCatalogUnit>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCatalogUnit> upperBound(double cost) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.add(Restrictions.le("cost", cost));
		return (List<ProductCatalogUnit>) criteria.list();
	}

	@Override
	public ProductCatalogUnit getProduct(String name) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.add(Restrictions.eq("product.name", name));
		return (ProductCatalogUnit) criteria.list().get(0);
	}

	@Override
	public ProductCatalogUnit getProduct(Feedback feedback) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.createAlias("product.feedbacks", "feedback")
				.add(Restrictions.eq("feedback.id", feedback.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (ProductCatalogUnit) criteria.uniqueResult();
	}

}
