package com.exposit.console.starter;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.domain.model.sorokin.Bonus;
import com.exposit.domain.model.sorokin.Client;
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
		UserDao userDao = (UserDao) context.getBean("userRepository");
		Client client = (Client) userDao.findById(1);
		System.out.println(client.getName());
		Client cli = (Client) userDao.findById(1);
		System.out.println(cli.getBonus().getPercentage());

	}

}
