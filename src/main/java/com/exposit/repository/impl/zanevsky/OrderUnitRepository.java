package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Status;
import com.exposit.repository.dao.zanevsky.OrderUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class OrderUnitRepository
		extends AbstractHibernateDao<OrderUnit, Integer>implements OrderUnitDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderUnit> getOrderUnitsList(Order order) {
		Criteria criteria = this.getSession().createCriteria(OrderUnit.class, "unit")
				.add(Restrictions.eq("order", order));
		return (List<OrderUnit>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderUnit> getOrderUnitsList(ProductCatalogUnit catalogUnit) {
		Criteria criteria = this.getSession().createCriteria(OrderUnit.class, "unit")
				.add(Restrictions.eq("productCatalogUnit", catalogUnit));
		return (List<OrderUnit>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderUnit> getOrderUnitsList(Status status) {
		Criteria criteria = this.getSession().createCriteria(OrderUnit.class, "unit")
				.add(Restrictions.eq("status", status));
		return (List<OrderUnit>) criteria.list();
	}
	
}
