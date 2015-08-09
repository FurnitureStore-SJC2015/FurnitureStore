package com.exposit.web.zanevsky;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;

@Controller
@RequestMapping("/Catalog")
public class CatalogController {
	
	@Autowired
	private ProductCatalogUnitService productService;
	
	@RequestMapping(value = {"", "/", "/all"}, method = RequestMethod.GET)
	public String showCatalog(Model model){
		List<ProductCatalogUnit> list = this.productService.getAllProductCatalogUnits();
		for(ProductCatalogUnit item : list){
			System.out.println(item.getId() + " " + item.getName());
		}
		//ggg
		model.addAttribute("list", list);
		return "shop.catalog";
	}
	
//	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
//	public String showAdminPanel(Model model) {
//		//model.addAttribute("userList", UserRepository.getUsers());
//		return "adminPanel";
//	}
	
}
