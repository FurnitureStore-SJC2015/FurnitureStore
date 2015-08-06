package com.exposit.console.starter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.model.zanevsky.RangeType;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.domain.model.zanevsky.Status;
import com.exposit.repository.dao.dobrilko.ProviderDao;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.dao.dobrilko.StorageModuleUnitDao;
import com.exposit.repository.dao.sorokin.OrderDao;
import com.exposit.repository.dao.sorokin.UserDao;
import com.exposit.repository.dao.zanevsky.FeedbackDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.repository.dao.zanevsky.OrderUnitDao;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;
import com.exposit.repository.dao.zanevsky.ProductTemplateDao;
import com.exposit.repository.dao.zanevsky.SaleDao;
import com.exposit.repository.dao.zanevsky.StatusDao;

import static java.lang.System.*;

public class vviitalTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		BaseTest<Feedback> feedbackTest = new FeedbackRepositoryTest();
		feedbackTest.criteriaTest(context);
		
		BaseTest<Module> moduleTest = new ModuleRepositoryTest();
		moduleTest.criteriaTest(context);
		
		BaseTest<OrderUnit> orderUnitTest = new OrderUnitRepositoryTest();
		orderUnitTest.criteriaTest(context);
		
		BaseTest<ProductCatalogUnit> productsTest = new ProductCatalogUnitRepositoryTest();
		productsTest.criteriaTest(context);
		
		BaseTest<ProductTemplate> templatesTest = new ProductTemplateRepositoryTest();
		templatesTest.criteriaTest(context);
		
		BaseTest<Sale> salesTest = new SaleRepositoryTest();
		salesTest.criteriaTest(context);
		
		BaseTest<Status> statusesTest = new StatusRepositoryTest();
		statusesTest.criteriaTest(context);
	}
}


class FeedbackRepositoryTest implements BaseTest<Feedback> {

	@Override
	public void test(ApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criteriaTest(ApplicationContext context) {
		// TODO Auto-generated method stub
		FeedbackDao feedbackDao = (FeedbackDao) context.getBean("feedbackRepository");
		UserDao userDao = (UserDao) context.getBean("userRepository");
		ProductCatalogUnitDao catalogUnitDao = (ProductCatalogUnitDao) context.getBean("productCatalogUnitRepository");
		
		User user = (User) userDao.findById(4);
		ProductCatalogUnit catalogUnit = (ProductCatalogUnit) catalogUnitDao.findById(1);
		
		List<Feedback> feedbacks = feedbackDao.getFeedacksList(user);
		
		Show(feedbacks);
		
		feedbacks = feedbackDao.getFeedbackList(catalogUnit);
		
		Show(feedbacks);
		
		double cost = feedbackDao.getAverageMark(catalogUnit);
		
		out.println(cost);
	}
	
	@Override
	public void Show(Feedback entity) {
		out.println(entity.getId() + " " + entity.getText());
	}

	@Override
	public void Show(List<Feedback> list) {
		for(Feedback x : list){
			Show(x);
		}
	}
	
}

class ModuleRepositoryTest implements BaseTest<Module> {

	@Override
	public void test(ApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criteriaTest(ApplicationContext context) {
		ModuleDao moduleDao = (ModuleDao) context.getBean("moduleRepository");
		ProductCatalogUnitDao productDao = (ProductCatalogUnitDao) context.getBean("productCatalogUnitRepository");
		ProviderDao providerDao = (ProviderDao) context.getBean("providerRepository");
		StorageModuleUnitDao moduleUnitDao = (StorageModuleUnitDao) context.getBean("storageModuleUnitRepository");
		ProductTemplateDao templateDao = (ProductTemplateDao) context.getBean("productTemplateRepository");
		ShipmentUnitDao shipmentUnitDao = (ShipmentUnitDao) context.getBean("shipmentUnitRepository");
		RequestUnitDao requestUnitDao = (RequestUnitDao) context.getBean("requestUnitRepository");
		
		Provider provider = providerDao.findById(1);
		List<Module> modules = moduleDao.getModules(provider);
		
		Show(modules);
		
		ProductCatalogUnit productCatalogUnit = productDao.findById(1);
		modules = moduleDao.getModules(productCatalogUnit);
		
		Show(modules);
		
		ProductTemplate template = (ProductTemplate) templateDao.findById(1);
		Module module = moduleDao.getModule(template);
		
		Show(module);
		
		StorageModuleUnit moduleUnit = (StorageModuleUnit) moduleUnitDao.findById(2);
		module = moduleDao.getModule(moduleUnit);
		
		Show(module);
		
		
		ShipmentUnit shipmentUnit = shipmentUnitDao.findById(1);
		module = moduleDao.getModule(shipmentUnit);
		
		Show(module);
		
		RequestUnit requestUnit = requestUnitDao.findById(1);
		module = moduleDao.getModule(requestUnit);
		
		Show(module);
	}

	@Override
	public void Show(List<Module> list) {
		for(Module x : list){
			Show(x);
		}
	}

	@Override
	public void Show(Module entity) {
		out.println(entity.getId() + " " + entity.getModuleType());
	}
	
}

class OrderUnitRepositoryTest implements BaseTest<OrderUnit> {

	@Override
	public void test(ApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criteriaTest(ApplicationContext context) {
		
		OrderUnitDao orderUnitDao = (OrderUnitDao) context.getBean("orderUnitRepository");
		OrderDao orderDao = (OrderDao) context.getBean("orderRepository");
		ProductCatalogUnitDao catalogUnitDao = (ProductCatalogUnitDao) context.getBean("productCatalogUnitRepository");
		StatusDao statusDao = (StatusDao) context.getBean("statusRepository");
		
		Order order = orderDao.findById(1);
		ProductCatalogUnit catalogUnit = catalogUnitDao.findById(1);
		Status status = statusDao.findById(1);
		
		List<OrderUnit> list = orderUnitDao.getOrderUnitsList(order);
		Show(list);
		
		list = orderUnitDao.getOrderUnitsList(catalogUnit);
		Show(list);
		
		list = orderUnitDao.getOrderUnitsList(status);
		Show(list);
	}

	@Override
	public void Show(List<OrderUnit> list) {
		for(OrderUnit x : list)
			Show(x);
	}

	@Override
	public void Show(OrderUnit entity) {
		// TODO Auto-generated method stub
		out.println(entity.getId() +  " " + entity.getCost());
	}
	
}

class ProductCatalogUnitRepositoryTest implements BaseTest<ProductCatalogUnit>{

	@Override
	public void test(ApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	@Override
	public void criteriaTest(ApplicationContext context) {
		// TODO Auto-generated method stub
		
		ProductCatalogUnitDao productDao = (ProductCatalogUnitDao) context.getBean("productCatalogUnitRepository");
		OrderDao orderDao = (OrderDao) context.getBean("orderRepository");
		UserDao userDao = (UserDao) context.getBean("userRepository");
		SaleDao saleDao = (SaleDao) context.getBean("saleRepository");
		ModuleDao moduleDao = (ModuleDao) context.getBean("moduleRepository");
		ProductTemplateDao templateDao = (ProductTemplateDao) context.getBean("productTemplateRepository");
		FeedbackDao feedbackDao = (FeedbackDao) context.getBean("feedbackRepository");
		
		Order order = orderDao.findById(1);
		User user = userDao.findById(4);
		Sale sale = saleDao.findById(1);
		Module module = moduleDao.findById(1);
		ProductTemplate template = templateDao.findById(1);
		Feedback feedback = feedbackDao.findById(1);
		
		List<ProductCatalogUnit> products = productDao.getProducts(order);
		Show(products);
		
		products = productDao.getProducts(user);
		Show(products);
		
		products = productDao.getProducts(sale);
		Show(products);
		
		products = productDao.getProducts(module);
		Show(products);
		
		products = productDao.lowerBound(10000);
		Show(products);
		
		products = productDao.upperBound(10000);
		Show(products);
		
		ProductCatalogUnit product = productDao.getProduct("Chair");
		Show(product);
		
		product = productDao.getProduct(feedback);
		Show(product);
		
	}

	@Override
	public void Show(List<ProductCatalogUnit> list) {
		for(ProductCatalogUnit x : list)
			Show(x);
	}

	@Override
	public void Show(ProductCatalogUnit entity) {
		out.println(entity.getId() + " " + entity.getName() + " " + entity.getCost() + " " + entity.getCoefficient());
	}
	
}

class ProductTemplateRepositoryTest implements BaseTest<ProductTemplate>{

	@Override
	public void test(ApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criteriaTest(ApplicationContext context) {
		// TODO Auto-generated method stub
		ProductTemplateDao templateDao = (ProductTemplateDao) context.getBean("productTemplateRepository");
		ProductCatalogUnitDao catalogUnitDao = (ProductCatalogUnitDao) context.getBean("productCatalogUnitRepository");
		ModuleDao moduleDao = (ModuleDao) context.getBean("moduleRepository");
		
		ProductCatalogUnit product = catalogUnitDao.findById(1);
		Module module = moduleDao.findById(1);
		
		List<ProductTemplate> templates = templateDao.getProductTemplatesList(product);
		Show(templates);
		
		templates = templateDao.getProductTemplatesList(module);
		Show(templates);
	}

	@Override
	public void Show(List<ProductTemplate> list) {
		for(ProductTemplate x : list)
			Show(x);
	}

	@Override
	public void Show(ProductTemplate entity) {
		// TODO Auto-generated method stub
		out.println(entity.getId() + " " + entity.getCount());
	}
	
}

class SaleRepositoryTest implements BaseTest<Sale>{

	@Override
	public void test(ApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criteriaTest(ApplicationContext context) {
		// TODO Auto-generated method stub
		ProductCatalogUnitDao catalogUnitDao = (ProductCatalogUnitDao) context.getBean("productCatalogUnitRepository");
		SaleDao saleDao = (SaleDao) context.getBean("saleRepository");
		
		ProductCatalogUnit product = catalogUnitDao.findById(1);
		
		Sale sale = saleDao.getSale(product);
		Show(sale);
		
	}

	@Override
	public void Show(List<Sale> list) {
		// TODO Auto-generated method stub
		for(Sale x : list)
			Show(x);
	}

	@Override
	public void Show(Sale entity) {
		// TODO Auto-generated method stub
		out.println(entity.getId() + " " + entity.getStartTime() + " " + entity.getEndTime());
	}
	
}

class StatusRepositoryTest implements BaseTest<Status>{

	@Override
	public void test(ApplicationContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criteriaTest(ApplicationContext context) {
		// TODO Auto-generated method stub
		StatusDao statusDao = (StatusDao) context.getBean("statusRepository");
		OrderUnitDao unitDao = (OrderUnitDao) context.getBean("orderUnitRepository");
		
		OrderUnit unit = unitDao.findById(1);
		
		Status status = statusDao.getStatus(unit);
		Show(status);
	}

	@Override
	public void Show(List<Status> list) {
		// TODO Auto-generated method stub
		for(Status x : list)
			Show(x);
	}

	@Override
	public void Show(Status entity) {
		// TODO Auto-generated method stub
		out.println(entity.getId() + " " + entity.getStatusType());
	}
	
}

interface BaseTest <T>{
	
	public void test(ApplicationContext context);
	
	public void criteriaTest(ApplicationContext context);
	
	public void Show(List<T> list);
	
	public void Show(T entity);
}
