package com.exposit.web.sorokin;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.model.sorokin.ShoppingCart;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.sorokin.PaymentService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.OrderUnitService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderUnitService orderUnitService;

	@Autowired
	private ShoppingCart shoppingCart;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String checkOrder(
			@RequestParam("schemeSelector") PaymentScheme paymentScheme,
			Model model) {
		model.addAttribute("order", orderService.createNewOrder(paymentScheme));
		return "client.new.order";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrder(
			@ModelAttribute("paymentScheme") PaymentScheme scheme,
			Principal principal) {
		Client client = (Client) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		Order order = orderService.createNewOrder(scheme);
		order.setClient(client);
		orderService.createNewOrder(order);
		return "redirect:/client/";
	}
}
