package com.exposit.web.dto.serviceImpl.zanevsky;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.service.zanevsky.FeedbackService;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.domain.service.zanevsky.ProductTemplateService;
import com.exposit.web.dto.service.zanevsky.ProductDtoService;
import com.exposit.web.dto.zanevsky.ProductDto;
import com.exposit.web.dto.zanevsky.ProductSearchCriteria;

@Service
@Transactional
public class ProductDtoServiceImpl implements ProductDtoService {

	@Autowired
	private ProductCatalogUnitService productService;

	@Autowired
	private ProductTemplateService productTemplateService;

	@Autowired
	private FeedbackService feedbackService;

	@Override
	public List<ProductDto> getAllProductCatalogUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto getEmptyProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getProductByCriteria(ProductSearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<ProductDto> getAllProductCatalogUnits() {
		List<ProductCatalogUnit> list = this.productService
				.getAllProductCatalogUnits();
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		for (ProductCatalogUnit product : list) {
			productDtos.add(this.converter
					.Convert(product, this.productService));
		}
		return productDtos;
	}

	@Override
	public ProductDto findById(int id) {
		ProductCatalogUnit product = this.productService.findById(id);
		return this.converter.Convert(product, this.productService);
	}

	@Override
	public ProductDto getEmptyProduct() {
		ProductDto product = new ProductDto();
		product.setTemplates(this.productTemplateService
				.getEmptyProductTemplatesList());
		return product;
	}

	@Override
	public List<ProductDto> getProductByCriteria(ProductSearchCriteria criteria) {
		List<ProductDto> products = new ArrayList<ProductDto>();
		List<ProductCatalogUnit> productUnits = this.productService
				.findByCriteria(criteria);
		for (ProductCatalogUnit product : productUnits) {
			products.add(this.converter.Convert(product, productService));
		}
		return products;
	}*/
}
