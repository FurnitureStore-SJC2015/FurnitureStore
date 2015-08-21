package com.exposit.web.dto.service.zanevsky;

import java.util.List;

import com.exposit.web.dto.zanevsky.ProductDto;
import com.exposit.web.dto.zanevsky.ProductSearchCriteria;

public interface ProductDtoService {

	public List<ProductDto> getAllProductCatalogUnits();
	
	public ProductDto findById(int id);
	
	public ProductDto getEmptyProduct();
	
	public List<ProductDto> getProductByCriteria(ProductSearchCriteria criteria);
}
