package com.exposit.web.sorokin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String initClient(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Order> orders = orderService.getOrders(user);
		user.setOrders(orderService.getOrders(user));

		byte[] encoded = Base64.encodeBase64(user.getAvatar());
		String encodedString = new String(encoded);
		session.setAttribute("image", encodedString);
		session.setAttribute("orderList", orders);// TODO 2 params of List???
		return "redirect:profile/";

	}

	@RequestMapping(value = "profile/", method = RequestMethod.GET)
	public String showProfile() {
		return "client.profile";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String showOrders() {
		return "client.orders";
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String showOrder(@PathVariable(value = "id") Order order, Model model) {
		model.addAttribute("order", order);
		return "client.order";
	}
}
