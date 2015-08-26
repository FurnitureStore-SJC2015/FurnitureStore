package com.exposit.web.sorokin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.web.dto.sorokin.ClientDto;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String initializeClient(Authentication auth, HttpSession session) {
		Client client = (Client) userService.findUserByName(auth.getName());
		ClientDto clientDto = new ClientDto.Builder(client,
				orderService.getOrdersCount(client)).build();
		session.setAttribute("loggedClient", clientDto);
		return "redirect:/profile";
	}
}
