package com.exposit.domain.service;

import com.exposit.domain.model.Client;

public interface MailService {

	public void sendRegistrationMail(String login,String password,String email);
	
	public void sendConfirationMail(Client client);
}
