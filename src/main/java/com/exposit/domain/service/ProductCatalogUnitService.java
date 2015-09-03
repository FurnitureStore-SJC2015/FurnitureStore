package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.Module;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.User;

public interface ProductCatalogUnitService {

	public List<ProductCatalogUnit> getAllProductCatalogUnits();

	public ProductCatalogUnit findById(int id);

	public String processImage(ProductCatalogUnit product);

	public List<ProductCatalogUnit> getProducts(Order order);

	public List<ProductCatalogUnit> getProducts(User user);

	public List<ProductCatalogUnit> getProducts(Module module);

	public List<ProductCatalogUnit> lowerBound(double cost);

	public List<ProductCatalogUnit> upperBound(double cost);

	public ProductCatalogUnit getProduct(String name);

	public ProductCatalogUnit getProduct(Feedback feedback);

	public ProductCatalogUnit getEmptyProduct();

	public void save(ProductCatalogUnit product);

	public void removeById(int id);

	public void addNewProduct(ProductCatalogUnit product);
}
