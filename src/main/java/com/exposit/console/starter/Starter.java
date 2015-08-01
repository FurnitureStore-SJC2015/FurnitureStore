package com.exposit.console.starter;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.model.sorokin.User;
import com.exposit.repository.dao.sorokin.OrderDao;
import com.exposit.repository.dao.sorokin.PaymentDao;
import com.exposit.repository.dao.sorokin.PaymentFormDao;
import com.exposit.repository.dao.sorokin.PaymentSchemeDao;
import com.exposit.repository.dao.sorokin.RoleDao;
import com.exposit.repository.dao.sorokin.UserDao;

public class Starter {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		UserDao userDao = (UserDao) context.getBean("userRepository");
		OrderDao orderDao = (OrderDao) context.getBean("orderRepository");
		RoleDao roleDao = (RoleDao) context.getBean("roleRepository");
		PaymentSchemeDao psDao = (PaymentSchemeDao) context
				.getBean("paymentSchemeRepository");
		PaymentFormDao pfDao = (PaymentFormDao) context
				.getBean("paymentFormRepository");
		User user = userDao.findById(2);
		PaymentDao paymentDao = (PaymentDao) context
				.getBean("paymentRepository");

		/*
		 * // user.setOrders(orderDao.getListOfUserOrders(user)); Order order1 =
		 * new Order(); order1.setExecutionDate(new Date());
		 * order1.setOrderDate(new Date());
		 * order1.setPaymentScheme(psDao.findById(1)); //order1.setUser(user);
		 * List<Order> orders = orderDao.getListOfUserOrders(user);
		 * orders.add(order1); user.setOrders(orders); userDao.update(user);
		 */
		Order order = orderDao.getListOfUserOrders(user).get(0);
		List<Payment> payments = paymentDao.getListOfAllPayments(order);
		Payment payment = new Payment();
		payment.setSum(20);
		payment.setPaymentStatus(false);
		payment.setDate(new Date());
		payments.add(payment);
		order.setPayments(payments);
		orderDao.update(order);
	}
}
