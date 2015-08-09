package com.exposit.service.zanevsky;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;

@Service
@Transactional
public class ProductCatalogUnitServiceImpl implements ProductCatalogUnitService {

	@Autowired
	private ProductCatalogUnitDao productDao;
	
	@Override
	public List<ProductCatalogUnit> getAllProductCatalogUnits() {
		return this.productDao.findAll();
	}
	
}
