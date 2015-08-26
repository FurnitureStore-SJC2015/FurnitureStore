package com.exposit.web.sorokin;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.service.sorokin.MailService;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.sorokin.PaymentService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.OrderUnitService;
import com.exposit.web.dto.service.PaymentDtoService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderUnitService orderUnitService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@Autowired
	private PaymentDtoService paymentDtoService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String showOrders(Authentication auth, Model model) {
		Client client = (Client) userService.findUserByName(auth.getName());
		model.addAttribute("orderList", orderService.getOrders(client));
		return "client.orders";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showOrder(@PathVariable(value = "id") Order order, Model model) {
		order.setOrderUnits(orderUnitService.getOrderUnitsList(order));
		model.addAttribute("order", order);
		model.addAttribute("paymentList", paymentDtoService.getListOfDtoPayments(order));
		return "client.order";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String checkOrder(
			@RequestParam("schemeSelector") PaymentScheme paymentScheme,
			Model model) {
		model.addAttribute("order", orderService.preOrder(paymentScheme));
		return "client.new.order";
	}

	@RequestMapping(value = "/check/{id}", method = RequestMethod.GET)
	public String showOrderComposition(@PathVariable("id") Order order,
			Model model) {
		order.setOrderUnits(orderUnitService.getOrderUnitsList(order));
		model.addAttribute("order", order);
		return "client.new.order";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createNewOrder(
			@ModelAttribute("paymentScheme") PaymentScheme scheme,
			Principal principal) {
		Client client = (Client) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		Order order = orderService.preOrder(scheme);
		order.setClient(client);
		orderService.createNewOrder(order);
		return "redirect:/client/";
	}

	@RequestMapping(value = { "/confirm" }, method = RequestMethod.POST)
	public String confirmOrder(@RequestParam(value = "orderId") Order order,
			@RequestParam("confirmationDate") Date assemblyDate) {
		Order confirmedOrder = orderService.confirmOrder(order, assemblyDate);
		orderService.updateOrder(confirmedOrder);
		mailService.sendConfirationMail(order.getClient());
		return "redirect:/company/incoming";
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.POST)
	public String deleteOrder(@PathVariable("id") Order order) {
		orderService.deleteOrder(order);
		return "redirect:/company/incoming";
	}
}
