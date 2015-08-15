package com.exposit.service.zanevsky;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.domain.service.zanevsky.ProductTemplateService;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;

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
	public ProductCatalogUnit FindById(int id) {
		return this.productDao.findById(id);
	}

	@Override
	public String processImage(ProductCatalogUnit product) {
		byte[] rawImage = product.getImage();
		rawImage = Base64.encodeBase64(rawImage);
		String image = new String(rawImage);
		return image;
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
	public List<ProductCatalogUnit> getProducts(Sale sale) {
		return this.productDao.getProducts(sale);
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
		product.setProductTemplates(this.templateService.getEmptyProductTemplatesList());
		return product;
	}

	@Override
	public void Save(ProductCatalogUnit product) {
		this.productDao.save(product);
	}
	
}
