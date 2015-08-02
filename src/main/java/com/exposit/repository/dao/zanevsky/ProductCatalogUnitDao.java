package com.exposit.repository.dao.zanevsky;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.repository.base.GenericDao;

public interface ProductCatalogUnitDao extends GenericDao<ProductCatalogUnit, Integer>{
	
	public List<ProductCatalogUnit> getProducts(Order order);
	
	public List<ProductCatalogUnit> getProducts(User user);
	
	public List<ProductCatalogUnit> getProducts(Sale sale);
	
	public List<ProductCatalogUnit> getProducts(Feedback feedback);
	
	public List<ProductCatalogUnit> getProducts(Module module);
	
	public List<ProductCatalogUnit> getProducts(ProductTemplate template);
	
	public List<ProductCatalogUnit> lowerBound(double cost);
	
	public List<ProductCatalogUnit> upperBound(double cost);
	
	public ProductCatalogUnit getProducts(String name);
}
