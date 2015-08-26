package com.exposit.domain.service.sorokin;

import com.exposit.domain.model.sorokin.Client;

public interface MailService {

	public void sendRegistrationMail(String login,String password,String email);
	
	public void sendConfirationMail(Client client);
}
