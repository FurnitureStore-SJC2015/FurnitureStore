package com.exposit.web.dto.service.zanevsky;

import java.util.List;

import com.exposit.web.dto.zanevsky.ProductDto;

public interface ProductDtoService {

	public List<ProductDto> getAllProductCatalogUnits();
	
	public ProductDto FindById(int id);
}
