package com.exposit.repository.dao.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.repository.base.GenericDao;

public interface OrderDao extends GenericDao<Order, Integer> {

	public List<Order> getListOfUserOrders(User user);

}
