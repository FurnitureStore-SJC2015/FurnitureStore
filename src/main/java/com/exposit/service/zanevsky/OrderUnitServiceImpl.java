package com.exposit.service.zanevsky;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.ShoppingCart;
import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Status;
import com.exposit.domain.service.zanevsky.OrderUnitService;
import com.exposit.repository.dao.zanevsky.OrderUnitDao;

@Service
@Transactional
public class OrderUnitServiceImpl implements OrderUnitService {

	@Autowired
	OrderUnitDao orderUnitDao;

	@Override
	public OrderUnit findById(int id) {
		return this.orderUnitDao.findById(id);
	}

	@Override
	public List<OrderUnit> getOrderUnitsList(Order order) {
		return this.orderUnitDao.getOrderUnitsList(order);
	}

	@Override
	public List<OrderUnit> getOrderUnitsList(ProductCatalogUnit catalogUnit) {
		return this.orderUnitDao.getOrderUnitsList(catalogUnit);
	}

	@Override
	public List<OrderUnit> getOrderUnitsList(Status status) {
		return this.orderUnitDao.getOrderUnitsList(status);
	}

	@Override
	public List<OrderUnit> initializeOrderUnits(ShoppingCart cart) {
		List<OrderUnit> orderUnits = new ArrayList<OrderUnit>();
		for (int i = 0; i < cart.getSize(); i++) {
			OrderUnit orderUnit = new OrderUnit();
			orderUnit.setProductCatalogUnit(cart.getItems().get(i));
			orderUnit.setCost(cart.getItems().get(i).getCost());
			orderUnit.setProductCatalogUnit(cart.getItems().get(0));
			orderUnits.add(orderUnit);
		}
		return orderUnits;
	}

}
