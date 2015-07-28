package com.exposit.console.starter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		/*
		 * тут достаем бины через context.getBean("beanName"); /* дабы не
		 * плодить код в xml,в аннотации @Component() или @Repository в нашем
		 * случае инициируем имя и с ним работаем. Пока так!
		 */

	}
}
