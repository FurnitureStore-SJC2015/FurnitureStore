package com.exposit.web.zanevsky;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.web.dto.service.zanevsky.ProductDtoService;
import com.exposit.web.dto.zanevsky.ProductDto;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private ProductDtoService productService;
	
	@RequestMapping(value = {"", "/", "/all"}, method = RequestMethod.GET)
	public String showCatalog(Model model){
		List<ProductDto> list = this.productService.getAllProductCatalogUnits();
		model.addAttribute("list", list);
		model.addAttribute("pageCount", 12);
		return "shop.catalog";
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable int id, Model model){
		ProductDto product = this.productService.FindById(id);
		model.addAttribute("product", product);
		model.addAttribute("modulesCount", 42);
		return "shop.product";
	}
	
}
