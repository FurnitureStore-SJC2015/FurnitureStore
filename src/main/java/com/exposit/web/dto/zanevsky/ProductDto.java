package com.exposit.web.dto.zanevsky;

import java.util.List;

import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;

public class ProductDto {

	private ProductCatalogUnit product;

	private List<Feedback> feedbacks;

	private List<ProductTemplate> templates;

	private ProductDto(Builder builder) {
		this.product = builder.getProduct();
		this.feedbacks = builder.getFeedbacks();
		this.templates = builder.getTemplates();
	}

	public ProductCatalogUnit getProduct() {
		return product;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public List<ProductTemplate> getTemplates() {
		return templates;
	}

	public static class Builder {

		private ProductCatalogUnit product;
		private List<Feedback> feedbacks;
		private List<ProductTemplate> templates;

		public Builder(ProductCatalogUnit product, List<Feedback> feedbacks,
				List<ProductTemplate> templates) {
			this.product = product;
			this.feedbacks = feedbacks;
			this.templates = templates;
		}

		public Builder product(ProductCatalogUnit product) {
			this.product = product;
			return this;
		}

		public Builder feebacks(List<Feedback> feedbacks) {
			this.feedbacks = feedbacks;
			return this;
		}

		public Builder templates(List<ProductTemplate> templates) {
			this.templates = templates;
			return this;
		}

		public ProductDto build() {
			return new ProductDto(this);
		}

		public ProductCatalogUnit getProduct() {
			return product;
		}

		public List<Feedback> getFeedbacks() {
			return feedbacks;
		}

		public List<ProductTemplate> getTemplates() {
			return templates;
		}

	}

}
