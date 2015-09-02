package com.exposit.domain.service;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.Order;
import com.exposit.domain.model.Payment;
import com.exposit.domain.model.PaymentScheme;
import com.exposit.domain.model.User;

public interface OrderService {

	public void createNewOrder(Order order);

	public void deleteOrder(Order order);

	public void deleteOrder(int id);

	public Order getOrderById(int id);

	public void updateOrder(Order order);

	public List<Order> getOrders(User user);

	public Integer getOrdersCount(User user);

	public Order confirmOrder(Order order, Date assemblyDate);

	public Order preOrder(PaymentScheme paymentScheme);

	public List<Order> getListOfOrdersToConfirm();

	public Double getOrderSum(Order order);

	public Order getOrderByPayment(Payment payment);

	public boolean isFullyPaid(Order order);
}
