package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.sorokin.ShoppingCart;
import com.exposit.domain.service.sorokin.ShoppingCartService;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showCart(Model model) {
		return "client.cart";
	}
}
