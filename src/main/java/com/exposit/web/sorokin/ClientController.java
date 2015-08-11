package com.exposit.web.sorokin;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.model.sorokin.Order;
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
	public String initClient() {
		return "redirect:profile/";

	}

	@RequestMapping(value = "profile/", method = RequestMethod.GET)
	public ModelAndView showProfile(HttpSession session, Authentication auth) {
		Client client = (Client) userService.findUserByName(auth.getName());
		ModelAndView modelAndView = new ModelAndView();
		byte[] encodedImage = Base64.encodeBase64(client.getAvatar());
		String image = new String(encodedImage);
		modelAndView.addObject("user", client).addObject("image", image)
				.addObject("orderCount", orderService.getOrdersCount(client));
		modelAndView.setViewName("client.profile");
		return modelAndView;
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String showOrders(Model model) {
		Client client = (Client) model.asMap().get("client");
		System.out.println(client.getName());
		return "client.orders";
	}

	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String showOrder(@PathVariable(value = "id") Order order, Model model) {
		model.addAttribute("order", order);
		return "client.order";
	}
}
