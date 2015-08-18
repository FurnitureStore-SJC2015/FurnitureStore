package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.model.sorokin.ShoppingCart;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.sorokin.PaymentService;
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

	@RequestMapping("/check")
	public String checkOrder(
			@RequestParam("schemeSelector") PaymentScheme paymentScheme,
			Model model) {
		model.addAttribute("order", orderService.createNewOrder(paymentScheme));
		return "client.new.order";
	}
}
