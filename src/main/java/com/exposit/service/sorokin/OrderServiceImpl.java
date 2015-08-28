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
import com.exposit.domain.model.zanevsky.OrderUnit;
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
	public Order confirmOrder(Order order, Date assemblyDate) {
		PaymentScheme scheme = order.getPaymentScheme();
		order.setAssemblyDate(assemblyDate);
		List<Payment> payments = paymentService.calculatePayments(order);
		order.setPayments(payments);
		order.setExecutionDate(payments.get(
				order.getPaymentScheme().getNumberOfPayments() - 1).getDate());
		return order;
	}

	@Override
	public Order preOrder(PaymentScheme paymentScheme) {
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setOrderUnits(orderUnitService
				.initializeOrderUnits(shoppingCartService.getShoppingCart()));
		order.setPaymentScheme(paymentScheme);
		return order;

	}

	@Override
	public List<Order> getListOfOrdersToConfirm() {
		return orderRepository.getListOfOrdersToConfirm();
	}

	@Override
	public Double getOrderSum(Order order) {
		List<OrderUnit> units = orderUnitService.getOrderUnitsList(order);
		double sum = 0;
		for (OrderUnit unit : units) {
			sum += unit.getCost();
		}
		return sum;
	}

	@Override
	public Order getOrderByPayment(Payment payment) {
		return orderRepository.getOrderByPayment(payment);
	}

}
