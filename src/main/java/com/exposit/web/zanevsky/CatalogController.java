package com.exposit.web.zanevsky;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.zanevsky.FeedbackService;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.domain.service.zanevsky.ProductTemplateService;
import com.exposit.web.dto.service.zanevsky.ProductDtoService;
import com.exposit.web.dto.zanevsky.ProductSearchCriteria;

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

	@RequestMapping(value = { "product/{id}"},method = RequestMethod.GET)
	public String showProduct(
			@PathVariable(value = "id") ProductCatalogUnit product, Model model) {
		product.setFeedbacks(feedbackService.getFeedbackList(product));
		model.addAttribute("product", product);
		return "shop.product";

	}

}
