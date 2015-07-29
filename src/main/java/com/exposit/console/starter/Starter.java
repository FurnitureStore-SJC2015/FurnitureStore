package com.exposit.console.starter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.repository.dao.RoleDao;

public class Starter {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		RoleDao repo = (RoleDao) context.getBean("roleRepository");
		System.out.println(repo.findById(2).getName().toString()); // it works!
	}
}
