package com.exposit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.Client;
import com.exposit.domain.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailSender mailSender;

	@Override
	public void sendRegistrationMail(String login, String password, String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("furniturestore3@gmail.com");
		message.setTo(email);
		message.setSubject("Registration is done!");
		message.setText("Welcome to Furniture Store.\nYour login: " + login
				+ "\nYour password: " + password);
		mailSender.send(message);
	}

	@Override
	public void sendConfirationMail(Client client) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("furniturestore3@gmail.com");
		message.setTo(client.getEmail());
		message.setSubject("Order confirmation");
		message.setText("Hi, "+client.getName()+".\nYour order confirmed! You can see your order in your profile!");
		mailSender.send(message);

	}
}
