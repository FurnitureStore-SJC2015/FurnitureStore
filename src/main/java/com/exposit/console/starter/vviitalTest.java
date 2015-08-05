package com.exposit.console.starter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.model.zanevsky.RangeType;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.repository.dao.dobrilko.ProviderDao;
import com.exposit.repository.dao.sorokin.UserDao;
import com.exposit.repository.dao.zanevsky.FeedbackDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;
import com.exposit.repository.dao.zanevsky.SaleDao;

import static java.lang.System.*;

public class vviitalTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		BaseTest<Feedback> feedbackTest = new FeedbackRepositoryTest();
		feedbackTest.criteriaTest(context);
		
		BaseTest<Module> moduleTest = new ModuleRepositoryTest();
		moduleTest.criteriaTest(context);
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
		
		Provider provider = providerDao.findById(1);
		List<Module> modules = moduleDao.getModules(provider);
		
		Show(modules);
		
		ProductCatalogUnit productCatalogUnit = productDao.findById(1);
		modules = moduleDao.getModules(productCatalogUnit);
		
		Show(modules);
		
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

interface BaseTest <T>{
	
	public void test(ApplicationContext context);
	
	public void criteriaTest(ApplicationContext context);
	
	public void Show(List<T> list);
	
	public void Show(T entity);
}
