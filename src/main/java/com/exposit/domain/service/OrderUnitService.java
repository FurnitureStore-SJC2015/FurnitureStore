package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.Order;
import com.exposit.domain.model.OrderUnit;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ShoppingCart;
import com.exposit.domain.model.Status;

public interface OrderUnitService {

	public OrderUnit findById(int id);

	public List<OrderUnit> getOrderUnitsList(Order order);

	public List<OrderUnit> getOrderUnitsList(ProductCatalogUnit catalogUnit);

	public List<OrderUnit> getOrderUnitsList(Status status);

	public List<OrderUnit> initializeOrderUnits(ShoppingCart cart);
}
