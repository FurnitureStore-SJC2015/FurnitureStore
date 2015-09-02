package com.exposit.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Order;
import com.exposit.domain.model.OrderUnit;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ShoppingCart;
import com.exposit.domain.model.Status;
import com.exposit.domain.service.OrderUnitService;
import com.exposit.repository.dao.OrderUnitDao;

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

		DecimalFormat df = new DecimalFormat("0");
		df.setRoundingMode(RoundingMode.UP);
		for (int i = 0; i < cart.getSize(); i++) {
			OrderUnit orderUnit = new OrderUnit();
			orderUnit.setProductCatalogUnit(cart.getItems().get(i));

			Double cost = cart.getItems().get(i).getCost()
					* cart.getItems().get(i).getCoefficient();
			orderUnit.setCost(Double.valueOf(df.format(cost)));
			orderUnit.setProductCatalogUnit(cart.getItems().get(i));
			orderUnits.add(orderUnit);
		}
		return orderUnits;
	}

}
