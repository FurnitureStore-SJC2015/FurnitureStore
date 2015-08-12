package com.exposit.service.zanevsky;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
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
	
}
