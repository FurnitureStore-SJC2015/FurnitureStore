package com.exposit.repository.impl.zanevsky;

import java.util.List;

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

	@Override
	public List<OrderUnit> getOrderUnitsList(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderUnit> getOrderUnitsList(ProductCatalogUnit catalogUnit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderUnit> getOrderUnitsList(Status status) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
