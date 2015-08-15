package com.exposit.service.zanevsky;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Status;
import com.exposit.domain.service.zanevsky.OrderUnitService;
import com.exposit.repository.dao.zanevsky.OrderUnitDao;

@Service
@Transactional
public class OrderUnitServiceImpl implements OrderUnitService{

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
	
}
