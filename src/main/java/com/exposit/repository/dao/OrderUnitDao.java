package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Order;
import com.exposit.domain.model.OrderUnit;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.Status;
import com.exposit.repository.base.GenericDao;

public interface OrderUnitDao extends GenericDao<OrderUnit, Integer>{
	
	public List<OrderUnit> getOrderUnitsList(Order order);
	
	public List<OrderUnit> getOrderUnitsList(ProductCatalogUnit catalogUnit);
	
	public List<OrderUnit> getOrderUnitsList(Status status);
	
}
