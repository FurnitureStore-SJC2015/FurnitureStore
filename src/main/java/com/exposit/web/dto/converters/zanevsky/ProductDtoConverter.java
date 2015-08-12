package com.exposit.web.dto.converters.zanevsky;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.web.dto.zanevsky.ProductDto;

public class ProductDtoConverter {
	
	public ProductDto Convert(ProductCatalogUnit product, ProductCatalogUnitService productService ){
		ProductDto dto = new ProductDto();
		dto.setId(product.getId());
		dto.setCost(product.getCost());
		dto.setDescription(product.getDescription());
		dto.setImage(productService.processImage(product));
		dto.setName(product.getName());
		dto.setSale(product.getSale().getPercentageSale());
		return dto;
	}
}
