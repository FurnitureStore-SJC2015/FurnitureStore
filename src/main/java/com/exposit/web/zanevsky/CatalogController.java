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
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.domain.service.zanevsky.ProductTemplateService;
import com.exposit.web.dto.service.zanevsky.ProductDtoService;
import com.exposit.web.dto.zanevsky.ProductDto;
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
	
	@RequestMapping(value = {"", "/", "/all"}, method = RequestMethod.GET)
	public ModelAndView showCatalog(Model model){
		List<ProductDto> products = this.productDtoService.getAllProductCatalogUnits();
		ModelAndView mav = new ModelAndView("shop.catalog");
		mav.addObject("products", products);
		return mav;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(Model model){
		ModelAndView mav = new ModelAndView();
		mav.addObject("searchCriteria", new ProductSearchCriteria());
		mav.setViewName("shop.catalog");
		return mav;
	}
	
	@RequestMapping(value = "/search/result", method = RequestMethod.GET)
	public ModelAndView searchResult(Model model, ProductSearchCriteria criteria){
		System.out.println(criteria.getMinCost() + " " + criteria.getMaxCost());
		List<ProductDto> products = this.productDtoService.getProductByCriteria(criteria);
		ModelAndView mav = new ModelAndView();
		mav.addObject("searchCriteria", criteria);
		mav.addObject("products", products);
		mav.setViewName("shop.catalog");
		return mav;
	}
	
	@RequestMapping(value = {"product/{id}", "/search/product/{id}"}, method = RequestMethod.GET)
	public ModelAndView showProduct(@PathVariable(value = "id") ProductDto product, Model model){
		ModelAndView mav = new ModelAndView("shop.product");
		mav.addObject("product", product);
		return mav;
	}
	
	@RequestMapping(value = "/action/add", method = RequestMethod.GET)
	public ModelAndView showProductAddForm(){
		ModelAndView modelAndView = new ModelAndView("catalog.add.product");
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
		this.productService.AddNewProduct(product);
		return "redirect:/catalog/";
	}
	
//	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
//	public String showProduct(@PathVariable int id, Model model){
//		ProductDto product = this.productDtoService.FindById(id);
//		model.addAttribute("product", product);
//		model.addAttribute("modulesCount", 42);
//		return "shop.product";
//	}
//	
//	@RequestMapping(value = "/action", method = RequestMethod.GET)
//	public ModelAndView chooseAction(){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("catalog.modify.action");
//		modelAndView.addObject("products", this.productDtoService.getAllProductCatalogUnits());
//		return modelAndView;
//	}
//	
//	@RequestMapping(value = "/action/add", method = RequestMethod.GET)
//	public ModelAndView showProductAddForm(){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("catalog.add.product");
//		modelAndView.addObject("product", this.productService.getEmptyProduct());
//		return modelAndView;
//	}
//	
//	@RequestMapping(value = "/action/add", method = RequestMethod.POST)
//	public String addProduct(@ModelAttribute("product") ProductCatalogUnit product, @RequestParam(value = "productImage") MultipartFile image){
//		try {
//			product.setImage(image.getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.productService.Save(product);
//		return "redirect:/catalog/action/";
//	}
//	
//	@RequestMapping(value = "/action/delete/product/{id}", method = RequestMethod.GET)
//	public String deleteProduct(@PathVariable("id") int id, Model model){
//		System.out.println("delete method run");
//		this.productService.RemoveById(id);
//		return "redirect:catalog/action/";
//	}
}
