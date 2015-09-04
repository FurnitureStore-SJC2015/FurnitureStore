package com.exposit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.service.FeedbackService;
import com.exposit.domain.service.ProductCatalogUnitService;
import com.exposit.domain.service.ProductTemplateService;
import com.exposit.web.dto.service.ProductDtoService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	private ProductDtoService productDtoService;

	@Autowired
	private ProductCatalogUnitService productService;

	@Autowired
	private ProductTemplateService productTemplateService;

	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(value = { "", "/", "/all" }, method = RequestMethod.GET)
	public String showCatalog(Model model) {
		model.addAttribute("products",
				productDtoService.getAllProductCatalogUnits());
		return "shop.catalog";
	}

	@RequestMapping(value = { "product/{id}" }, method = RequestMethod.GET)
	public String showProduct(
			@PathVariable(value = "id") ProductCatalogUnit product, Model model)
			throws NullPointerException {
		product.setFeedbacks(feedbackService.getFeedbackList(product));
		model.addAttribute("product", product);
		return "shop.product";
	}

}
