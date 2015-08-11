package com.exposit.service.sorokin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.repository.dao.sorokin.OrderDao;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderRepository;

	@Override
	public void createNewOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Order order) {
		orderRepository.delete(order);

	}

	@Override
	public Order getOrderById(int id) {
		return orderRepository.findById(id);
	}

	@Override
	public List<Order> getOrders(User user) {
		return orderRepository.getListOfUserOrders(user);
	}

	@Override
	public void updateOrder(Order order) {
		orderRepository.update(order);

	}

	@Override
	public void deleteOrder(int id) {
		orderRepository.delete(id);

	}

	@Override
	public Integer getOrdersCount(User user) {
		return orderRepository.getSizeOfClientOrdersList(user);
	}

}
