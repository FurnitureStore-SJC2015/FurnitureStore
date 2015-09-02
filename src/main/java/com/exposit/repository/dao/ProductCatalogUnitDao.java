package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.Module;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.User;
import com.exposit.repository.base.GenericDao;
import com.exposit.web.dto.ProductSearchCriteria;

public interface ProductCatalogUnitDao extends
		GenericDao<ProductCatalogUnit, Integer> {

	public List<ProductCatalogUnit> getProducts(Order order);

	public List<ProductCatalogUnit> getProducts(User user);

	public List<ProductCatalogUnit> getProducts(Module module);

	public List<ProductCatalogUnit> lowerBound(double cost);

	public List<ProductCatalogUnit> upperBound(double cost);

	public ProductCatalogUnit getProduct(String name);

	public ProductCatalogUnit getProduct(Feedback feedback);

	public List<ProductCatalogUnit> getProductByCustomCriteria(
			ProductSearchCriteria criteria);
}
