package com.exposit.service.sorokin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.sorokin.PaymentService;
import com.exposit.domain.service.sorokin.ShoppingCartService;
import com.exposit.domain.service.zanevsky.OrderUnitService;
import com.exposit.repository.dao.sorokin.OrderDao;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderRepository;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private OrderUnitService orderUnitService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Override
	public void createNewOrder(Order order) {
		orderRepository.save(order);
		shoppingCartService.clearCart();
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

	@Override
	public Order createNewOrder(PaymentScheme paymentScheme) {
		List<Payment> payments = paymentService
				.calculatePayments(paymentScheme);
		Order order = new Order();
		order.setOrderUnits(orderUnitService
				.initializeOrderUnits(shoppingCartService.getShoppingCart()));
		order.setPayments(payments);
		order.setPaymentScheme(paymentScheme);
		order.setOrderDate(new Date());
		order.setExecutionDate(payments.get(
				paymentScheme.getNumberOfPayments() - 1).getDate());
		return order;
	}

}
