package com.exposit.domain.service.zanevsky;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.ShoppingCart;
import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Status;

public interface OrderUnitService {

	public OrderUnit findById(int id);

	public List<OrderUnit> getOrderUnitsList(Order order);

	public List<OrderUnit> getOrderUnitsList(ProductCatalogUnit catalogUnit);

	public List<OrderUnit> getOrderUnitsList(Status status);

	public List<OrderUnit> initializeOrderUnits(ShoppingCart cart);
}
