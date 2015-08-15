package com.exposit.domain.service.zanevsky;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.Sale;

public interface ProductCatalogUnitService {
	
	public List<ProductCatalogUnit> getAllProductCatalogUnits();
	
	public ProductCatalogUnit FindById(int id);
	
	public String processImage(ProductCatalogUnit product);
	
	public List<ProductCatalogUnit> getProducts(Order order);
	
	public List<ProductCatalogUnit> getProducts(User user);
	
	public List<ProductCatalogUnit> getProducts(Sale sale);
	
	public List<ProductCatalogUnit> getProducts(Module module);
	
	public List<ProductCatalogUnit> lowerBound(double cost);
	
	public List<ProductCatalogUnit> upperBound(double cost);
	
	public ProductCatalogUnit getProduct(String name);

	public ProductCatalogUnit getProduct(Feedback feedback);
	
	public ProductCatalogUnit getEmptyProduct();
	
	public void Save(ProductCatalogUnit product);
}
