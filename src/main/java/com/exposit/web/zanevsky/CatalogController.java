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

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private ProductCatalogUnitService productService;
	
	@RequestMapping(value = {"", "/", "/all"}, method = RequestMethod.GET)
	public String showCatalog(Model model){
		List<ProductCatalogUnit> list = this.productService.getAllProductCatalogUnits();
		for(ProductCatalogUnit item : list){
			System.out.println(item.getId() + " " + item.getName());
		}
		Map<Integer, String> map = new HashMap<>();
		for(ProductCatalogUnit product : list){
			map.put(product.getId(), this.productService.processImage(product));
		}
		Map<Integer, String> shortText = new HashMap<>();
		for(ProductCatalogUnit product : list){
			String shortDecs = String.copyValueOf(product.getDescription().toCharArray(), 0, Math.min(500, product.getDescription().length()));
			shortText.put(product.getId(), shortDecs);
		}
		model.addAttribute("list", list);
		model.addAttribute("pageCount", 12);
		model.addAttribute("images", map);
		model.addAttribute("texts", shortText);
		map.get(1);
		return "shop.catalog";
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable int id, Model model){
		ProductCatalogUnit product = this.productService.FindById(id);
		String image = this.productService.processImage(product);
		model.addAttribute("product", product);
		model.addAttribute("image", image);
		model.addAttribute("modulesCount", 42);
		return "shop.product";
		///
	}
	
}
