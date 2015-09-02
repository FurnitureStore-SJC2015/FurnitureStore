package com.exposit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.Module;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ProductTemplate;
import com.exposit.domain.model.User;
import com.exposit.domain.service.ProductCatalogUnitService;
import com.exposit.domain.service.ProductTemplateService;
import com.exposit.repository.dao.ProductCatalogUnitDao;
import com.exposit.web.dto.ProductSearchCriteria;

@Service
@Transactional
public class ProductCatalogUnitServiceImpl implements ProductCatalogUnitService {

	@Autowired
	private ProductCatalogUnitDao productDao;

	@Autowired
	private ProductTemplateService templateService;

	@Override
	public List<ProductCatalogUnit> getAllProductCatalogUnits() {
		return this.productDao.findAll();
	}

	@Override
	public ProductCatalogUnit findById(int id) {
		return this.productDao.findById(id);
	}

	@Override
	public String processImage(ProductCatalogUnit product) {
		return product.getImage();
	}

	@Override
	public List<ProductCatalogUnit> getProducts(Order order) {
		return this.productDao.getProducts(order);
	}

	@Override
	public List<ProductCatalogUnit> getProducts(User user) {
		return this.productDao.getProducts(user);
	}

	@Override
	public List<ProductCatalogUnit> getProducts(Module module) {
		return this.productDao.getProducts(module);
	}

	@Override
	public List<ProductCatalogUnit> lowerBound(double cost) {
		return this.productDao.lowerBound(cost);
	}

	@Override
	public List<ProductCatalogUnit> upperBound(double cost) {
		return this.productDao.upperBound(cost);
	}

	@Override
	public ProductCatalogUnit getProduct(String name) {
		return this.productDao.getProduct(name);
	}

	@Override
	public ProductCatalogUnit getProduct(Feedback feedback) {
		return this.productDao.getProduct(feedback);
	}

	@Override
	public ProductCatalogUnit getEmptyProduct() {
		ProductCatalogUnit product = new ProductCatalogUnit();
		product.setProductTemplates(this.templateService
				.getEmptyProductTemplatesList());
		for (ProductTemplate template : product.getProductTemplates()) {
			template.setProductCatalogUnit(product);
		}
		return product;
	}

	@Override
	public void save(ProductCatalogUnit product) {
		this.productDao.save(product);
	}

	@Override
	public void removeById(int id) {
		this.productDao.delete(id);
	}

	@Override
	public List<ProductCatalogUnit> findByCriteria(
			ProductSearchCriteria criteria) {
		return this.productDao.getProductByCustomCriteria(criteria);
	}

	@Override
	public void addNewProduct(ProductCatalogUnit product) {
		product.setCost(this.calculateApproximatePrice(product));
		for (ProductTemplate item : product.getProductTemplates()) {
			item.getModule().getProductTemplates().add(item);
		}

		this.productDao.save(product);
	}

	private double calculateApproximatePrice(ProductCatalogUnit product) {
		double price = 0;
		for (ProductTemplate item : product.getProductTemplates()) {
			price += item.getModule().getCost() * item.getCount();
		}
		price += price * product.getCoefficient() / 100;
		return price;
	}

}
