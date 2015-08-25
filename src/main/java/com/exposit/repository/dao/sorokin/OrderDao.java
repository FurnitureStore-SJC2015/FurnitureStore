package com.exposit.repository.dao.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.model.sorokin.User;
import com.exposit.repository.base.GenericDao;

public interface OrderDao extends GenericDao<Order, Integer> {

	public List<Order> getListOfUserOrders(User user);

	public Integer getSizeOfClientOrdersList(User user);

	public List<Order> getListOfOrdersByPaymentScheme(PaymentScheme scheme);

	public List<Order> getListOfOrdersToConfirm();

}
