package com.exposit.console.starter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.repository.dao.sorokin.UserDao;

public class Starter {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		UserDao userDao = (UserDao) context.getBean("userRepository");
		System.out.println(userDao.findById(1).getRole().getName());

	}
}
