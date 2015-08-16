package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;
import com.exposit.web.dto.zanevsky.ProductSearchCriteria;

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
				.add(Restrictions.eq("unit.order", order))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
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
	public List<ProductCatalogUnit> getProducts(Sale sale) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.add(Restrictions.eq("sale", sale));
		return (List<ProductCatalogUnit>) criteria.list();
	}

	// Игоря нету нигде, но результат все равно не однозначный...
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCatalogUnit> getProducts(Module module) {
		Criteria criteria = this.getSession()
				.createCriteria(ProductCatalogUnit.class, "product")
				.createAlias("product.productTemplates", "template")
				.add(Restrictions.eq("template.module", module))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		// .setProjection(Projections.distinct(Projections.property("product.id")));
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

	// спорный метод, делать ли имя уникальным или просто к возвращать лист один
	// мебели???
	// пока что так оставлю, а потом при написании логики всего решится
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCatalogUnit> getProductByCustomCriteria(
			ProductSearchCriteria criteria) {
		return (List<ProductCatalogUnit>) this.convert(criteria).list();
	}

	private Criteria convert(ProductSearchCriteria criteria) {
		Criteria cr = this.getSession().createCriteria(
				ProductCatalogUnit.class, "product");
		cr.add(Restrictions.ge("cost", criteria.getMinCost())).add(
				Restrictions.le("cost", criteria.getMaxCost()));
		return cr;
	}
}
