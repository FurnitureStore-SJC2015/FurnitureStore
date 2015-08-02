package com.exposit.console.starter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.model.zanevsky.RangeType;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;
import com.exposit.repository.dao.zanevsky.SaleDao;

import static java.lang.System.*;

public class vviitalTest {
	@SuppressWarnings("deprecation")
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		ProductCatalogUnitDao productDao = (ProductCatalogUnitDao) context.getBean("productCatalogUnitRepository");
		SaleDao saleDao = (SaleDao) context.getBean("saleRepository");
		ModuleDao moduleDao = (ModuleDao) context.getBean("moduleRepository");
		List<ProductCatalogUnit> list = productDao.findAll();
		
		ProductCatalogUnit product = makeProduct("Chair", 12.5, 2000);
		
		List<Feedback> feedbacks = new ArrayList<>();
		
		feedbacks.add(makeFeedback(product, "good", new Date(2015 - 1900, 8, 1), RangeType.FOUR));
		feedbacks.add(makeFeedback(product, "bad", new Date(2015 - 1900, 8, 1), RangeType.TWO));
		
		product.setFeedbacks(feedbacks);
		
		Sale sale = (Sale) saleDao.findAll().toArray()[0];
		
		product.setSale(sale);
		
		productDao.save(product);
		
		List<Module> modules = moduleDao.findAll();
		List<ProductTemplate> templates = new ArrayList<>();
		
		for(Module x : modules){
			templates.add(makeTemplate(product, x, 10));
		}
		
		product.setProductTemplates(templates);
		
		productDao.update(product);
		
		templates.add(makeTemplate(product, (Module)modules.toArray()[0], 11));
		
		productDao.update(product);
		
		int num = 0;
		
		productDao.delete(product);
	}
	
	ProductCatalogUnit makeProduct(String name, double coefficient, double cost){
		ProductCatalogUnit product = new ProductCatalogUnit();
		product.setName(name);
		product.setCoefficient(coefficient);
		product.setCost(cost);
		return product;
	}
	
	Feedback makeFeedback(ProductCatalogUnit product,String text, Date date, RangeType range){
		out.println(date.toString());
		Feedback feedback = new Feedback();
		feedback.setText(text);
		feedback.setDate(date);
		feedback.setRange(range);
		feedback.setProductCatalogUnit(product);
		return feedback;
	}
	
	ProductTemplate makeTemplate(ProductCatalogUnit product, Module module, int count){
		ProductTemplate template = new ProductTemplate();
		template.setCount(count);
		template.setProductCatalogUnit(product);
		template.setModule(module);
		return template;
	}
	
	
}
