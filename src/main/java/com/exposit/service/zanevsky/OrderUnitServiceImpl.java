package com.exposit.service.zanevsky;

import java.text.DecimalFormat;
import java.text.ParseException;
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
		
		DecimalFormat df=new DecimalFormat("0.00");
		
		
		for (int i = 0; i < cart.getSize(); i++) {
			OrderUnit orderUnit = new OrderUnit();
			orderUnit.setProductCatalogUnit(cart.getItems().get(i));
			
			String formate = df.format(cart.getItems().get(i).getCost()*cart.getItems().get(i).getCoefficient()); 
			try {
				orderUnit.setCost((double)df.parse(formate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			orderUnit.setProductCatalogUnit(cart.getItems().get(i));
			orderUnits.add(orderUnit);
		}
		return orderUnits;
	}

}
