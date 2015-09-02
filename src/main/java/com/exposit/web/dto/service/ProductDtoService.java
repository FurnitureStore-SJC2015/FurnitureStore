package com.exposit.web.dto.service;

import java.util.List;

import com.exposit.web.dto.ProductDto;
import com.exposit.web.dto.ProductSearchCriteria;

public interface ProductDtoService {

	public List<ProductDto> getAllProductCatalogUnits();
	
	//public ProductDto findById(int id);
	
	//public ProductDto getEmptyProduct();
	
	//public List<ProductDto> getProductByCriteria(ProductSearchCriteria criteria);
}
