package com.exposit.web.sorokin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.sorokin.ShoppingCartService;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showCart(Model model) {
		model.addAttribute("shoppingCart",
				shoppingCartService.getShoppingCart());
		return "client.cart";
	}

	@RequestMapping(value = "/add/{id}")
	// TODO
	public String addToCart(@PathVariable("id") ProductCatalogUnit product) {
		shoppingCartService.addOneProduct(product);
		return "redirect:/catalog";

	}
}
