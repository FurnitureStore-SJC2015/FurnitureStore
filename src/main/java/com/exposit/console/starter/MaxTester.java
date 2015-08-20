package com.exposit.console.starter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.domain.model.sorokin.RoleType;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.RoleService;
import com.exposit.repository.dao.sorokin.BonusDao;
import com.exposit.repository.dao.sorokin.OrderDao;
import com.exposit.repository.dao.sorokin.UserDao;

public class MaxTester {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		OrderDao orderDao = (OrderDao) context.getBean("orderRepository");
		RoleService roleService = (RoleService) context.getBean("roleService");
	}

}
