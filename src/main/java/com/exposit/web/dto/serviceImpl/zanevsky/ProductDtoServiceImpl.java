package com.exposit.web.dto.serviceImpl.zanevsky;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.web.dto.converters.zanevsky.ProductDtoConverter;
import com.exposit.web.dto.service.zanevsky.ProductDtoService;
import com.exposit.web.dto.zanevsky.ProductDto;

@Service
public class ProductDtoServiceImpl implements ProductDtoService{

	@Autowired
	private ProductCatalogUnitService productService;
	
	@Autowired
	private ProductDtoConverter converter;
	
	@Override
	public List<ProductDto> getAllProductCatalogUnits() {
		List<ProductCatalogUnit> list = this.productService.getAllProductCatalogUnits();
		List<ProductDto> productDtos = new ArrayList<>();
		for(ProductCatalogUnit product : list){
			productDtos.add(this.converter.Convert(product, this.productService));
		}
		return productDtos;
	}

	@Override
	public ProductDto FindById(int id) {
		ProductCatalogUnit product = this.productService.FindById(id);
		return this.converter.Convert(product, this.productService);
	}
	
	
}
