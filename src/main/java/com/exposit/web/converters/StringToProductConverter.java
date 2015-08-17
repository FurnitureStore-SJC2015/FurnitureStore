package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.web.dto.service.zanevsky.ProductDtoService;
import com.exposit.web.dto.zanevsky.ProductDto;

@Component
public class StringToProductConverter implements Converter<String, ProductDto>{

	@Autowired
	private ProductDtoService productService;
	
	@Override
	public ProductDto convert(String id) {
		return this.productService.FindById(Integer.valueOf(id));
	}

}
