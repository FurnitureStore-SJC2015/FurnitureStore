package com.exposit.web.dto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.service.FeedbackService;
import com.exposit.domain.service.ProductCatalogUnitService;
import com.exposit.domain.service.ProductTemplateService;
import com.exposit.domain.service.RangeService;
import com.exposit.web.dto.ProductDto;
import com.exposit.web.dto.service.ProductDtoService;

@Service
@Transactional
public class ProductDtoServiceImpl implements ProductDtoService {

	@Autowired
	private ProductCatalogUnitService productCatalogUnitService;

	@Autowired
	private ProductTemplateService productTemplateService;

	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private RangeService rangeService;

	@Override
	public List<ProductDto> getAllProductCatalogUnits() {
		List<ProductDto> products = new ArrayList<ProductDto>();
		for (ProductCatalogUnit product : productCatalogUnitService
				.getAllProductCatalogUnits()) {
			ProductDto productDto = new ProductDto(product,
					rangeService.countRange(product));
			products.add(productDto);
		}
		return products;
	}

}
