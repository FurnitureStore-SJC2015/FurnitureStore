package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;

public class StringToProductCatalogUnitConverter implements
		Converter<String, ProductCatalogUnit> {

	@Autowired
	private ProductCatalogUnitService productCatalogUnitService;

	@Override
	public ProductCatalogUnit convert(String id) {
		return productCatalogUnitService.FindById(Integer.valueOf(id));
	}

}
