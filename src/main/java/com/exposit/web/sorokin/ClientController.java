package com.exposit.web.sorokin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.sorokin.PaymentService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.OrderUnitService;
import com.exposit.web.dto.sorokin.ClientDto;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private OrderUnitService orderUnitService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String initializeClient(Authentication auth, HttpSession session) {
		Client client = (Client) userService.findUserByName(auth.getName());
		ClientDto clientDto = new ClientDto.Builder(client,
				orderService.getOrdersCount(client)).build();
		session.setAttribute("loggedClient", clientDto);
		return "redirect:/profile";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String showOrders(Authentication auth, Model model) {
		Client client = (Client) userService.findUserByName(auth.getName());
		model.addAttribute("orderList", orderService.getOrders(client));
		return "client.orders";
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String showOrder(@PathVariable(value = "id") Order order, Model model) {
		order.setOrderUnits(orderUnitService.getOrderUnitsList(order));
		order.setPayments(paymentService.getPayments(order));
		model.addAttribute("order", order);
		model.addAttribute("paymentList", paymentService.getPayments(order));
		return "client.order";
	}
}
