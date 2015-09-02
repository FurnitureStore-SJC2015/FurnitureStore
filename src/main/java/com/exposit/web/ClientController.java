package com.exposit.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.Client;
import com.exposit.domain.service.OrderService;
import com.exposit.domain.service.PaymentService;
import com.exposit.domain.service.UserService;
import com.exposit.web.dto.ClientDto;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String initializeClient(Authentication auth, HttpSession session) {
		Client client = (Client) userService.findUserByName(auth.getName());
		ClientDto clientDto = new ClientDto.Builder(client,
				orderService.getOrdersCount(client)).build();
		session.setAttribute("loggedClient", clientDto);
		return "redirect:/profile";
	}
}
