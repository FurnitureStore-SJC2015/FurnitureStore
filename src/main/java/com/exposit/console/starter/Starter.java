package com.exposit.console.starter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		/*
		 * ��� ������� ���� ����� context.getBean("beanName"); /* ���� ��
		 * ������� ��� � xml,� ��������� @Component() ��� @Repository � �����
		 * ������ ���������� ��� � � ��� ��������. ���� ���!
		 */

	}
}
