package com.exposit.web.sorokin;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.web.dto.sorokin.ProfileDto;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String initClient() {
		return "redirect:profile/";
	}

	@RequestMapping(value = "profile/", method = RequestMethod.GET)
	public String showProfile(Authentication auth, Model model) {
		Client client = (Client) userService.findUserByName(auth.getName());
		ProfileDto profile = new ProfileDto(client, client.getAvatar(),
				orderService.getOrdersCount(client));
		model.addAttribute("profile", profile);
		return "client.profile";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String showOrders(Authentication auth) {
		Client client = (Client) userService.findUserByName(auth.getName());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orderList", orderService.getOrders(client));
		return "client.orders";
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String showOrder(@PathVariable(value = "id") Order order, Model model) {
		model.addAttribute("order", order);
		return "client.order";
	}
}
