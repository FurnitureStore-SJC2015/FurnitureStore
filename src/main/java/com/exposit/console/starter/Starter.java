package com.exposit.console.starter;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.model.sorokin.User;
import com.exposit.repository.dao.dobrilko.ShipmentDao;
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
		ShipmentDao shipmentDao = (ShipmentDao) context
				.getBean("shipmentRepository");

		for (Shipment shipment : shipmentDao.findAll()) {
			System.out.println(shipment.getId());
			System.out.println(shipment.getProviderMarginPercent());
		}

	}
}
