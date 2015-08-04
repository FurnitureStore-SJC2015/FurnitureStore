package com.exposit.console.starter;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.domain.model.sorokin.Bonus;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.model.sorokin.PaymentType;
import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.repository.dao.sorokin.BonusDao;
import com.exposit.repository.dao.sorokin.OrderDao;
import com.exposit.repository.dao.sorokin.PaymentDao;
import com.exposit.repository.dao.sorokin.PaymentFormDao;
import com.exposit.repository.dao.sorokin.PaymentSchemeDao;
import com.exposit.repository.dao.sorokin.RoleDao;
import com.exposit.repository.dao.sorokin.UserDao;

public class MaxTester {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		
	}

	private static Order createNewOrder(PaymentScheme scheme) {
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setExecutionDate(new Date());
		order.setPaymentScheme(scheme);
		return order;
	}

	private static User createNewUser(String email, String login, String name,
			String password, String surname, Role role, Bonus bonus) {
		User user = new User();
		user.setEmail(email);
		user.setLogin(login);
		user.setName(name);
		user.setPassword(password);
		user.setSurname(surname);
		user.setRole(role);
		return user;
	}
}
