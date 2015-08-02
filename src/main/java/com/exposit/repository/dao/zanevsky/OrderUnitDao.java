package com.exposit.repository.dao.zanevsky;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Status;
import com.exposit.repository.base.GenericDao;

public interface OrderUnitDao extends GenericDao<OrderUnit, Integer>{
	
	public List<OrderUnit> getOrderUnitsList(Order order);
	
	public List<OrderUnit> getOrderUnitsList(ProductCatalogUnit catalogUnit);
	
	public List<OrderUnit> getOrderUnitsList(Status status);
	
}
