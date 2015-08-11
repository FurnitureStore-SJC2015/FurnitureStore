package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;

public interface OrderService {

	public void createNewOrder(Order order);

	public void deleteOrder(Order order);

	public void deleteOrder(int id);

	public Order getOrderById(int id);

	public void updateOrder(Order order);

	public List<Order> getOrders(User user);

	public Integer getOrdersCount(User user);
}
