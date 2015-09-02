package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Order;
import com.exposit.domain.model.Payment;
import com.exposit.domain.model.PaymentScheme;
import com.exposit.domain.model.User;
import com.exposit.repository.base.GenericDao;

public interface OrderDao extends GenericDao<Order, Integer> {

	public List<Order> getListOfUserOrders(User user);

	public Integer getSizeOfClientOrdersList(User user);

	public List<Order> getListOfOrdersByPaymentScheme(PaymentScheme scheme);

	public List<Order> getListOfOrdersToConfirm();

	public Order getOrderByPayment(Payment payment);
}
