package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/delete/{i}")
	public String removeFromCart(@PathVariable("i") int i) {
		// TODO exception
		shoppingCartService.removeAt(i - 1);
		return "client.cart";
	}

	@RequestMapping(value = "/add/many", method = RequestMethod.POST)
	public String addToCart(@RequestParam("count") Integer count,
			@RequestParam("productId") ProductCatalogUnit product) {
		shoppingCartService.addProduct(count, product);
		return "redirect:/catalog";

	}

}
