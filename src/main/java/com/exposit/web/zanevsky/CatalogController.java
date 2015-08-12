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
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value = "/action", method = RequestMethod.GET)
	public ModelAndView chooseAction(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("catalog.modify.action");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showProductAddForm(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("catalog.add.product");
		return modelAndView;
	}
	
	@RequestMapping(value = "c", method = RequestMethod.POST)
	public String addProduct(Model model){
		return "catalog.modify.action";
	}
	
}
