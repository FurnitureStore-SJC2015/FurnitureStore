package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.model.zanevsky.Sale;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ProductCatalogUnitRepository
		extends AbstractHibernateDao<ProductCatalogUnit, Integer>
		implements ProductCatalogUnitDao {

	@Override
	public List<ProductCatalogUnit> getProducts(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCatalogUnit> getProducts(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCatalogUnit> getProducts(Sale sale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCatalogUnit> getProducts(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCatalogUnit> getProducts(Module module) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCatalogUnit> getProducts(ProductTemplate template) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCatalogUnit> lowerBound(double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCatalogUnit> upperBound(double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCatalogUnit getProducts(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
