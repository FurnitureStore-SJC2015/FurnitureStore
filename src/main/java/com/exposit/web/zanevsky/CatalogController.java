package com.exposit.web.zanevsky;

import java.io.IOException;
import java.util.List;

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
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.domain.service.zanevsky.ProductTemplateService;
import com.exposit.web.dto.service.zanevsky.ProductDtoService;
import com.exposit.web.dto.zanevsky.ProductDto;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private ProductDtoService productDtoService;
	
	@Autowired
	private ProductCatalogUnitService productService;
	
	@Autowired
	private ProductTemplateService productTemplateService;
	
	@RequestMapping(value = {"", "/", "/all"}, method = RequestMethod.GET)
	public String showCatalog(Model model){
		List<ProductDto> list = this.productDtoService.getAllProductCatalogUnits();
		model.addAttribute("list", list);
		model.addAttribute("pageCount", 12);
		return "shop.catalog";
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable int id, Model model){
		ProductDto product = this.productDtoService.FindById(id);
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
	
	@RequestMapping(value = "/action/add", method = RequestMethod.GET)
	public ModelAndView showProductAddForm(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("catalog.add.product");
		ProductCatalogUnit product = this.productService.getEmptyProduct();
		for(ProductTemplate x : product.getProductTemplates()){
			System.out.println(x.getModule().getModuleType());
		}
		modelAndView.addObject("product", this.productService.getEmptyProduct());
		return modelAndView;
	}
	
	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") ProductCatalogUnit product, @RequestParam(value = "productImage") MultipartFile image){
		try {
			product.setImage(image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.productService.Save(product);
		return "redirect:/catalog/action/";
	}
}
