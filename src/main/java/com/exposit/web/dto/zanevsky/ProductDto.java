package com.exposit.web.dto.zanevsky;

import java.util.List;

import com.exposit.domain.model.zanevsky.ProductTemplate;

public class ProductDto {
	
	private int id;
	
	private double cost;
	
	private String name;
	
	private String description;
	
	private String image;
	
	private double sale;
	
	private List<ProductTemplate> templates;

	public List<ProductTemplate> getTemplates() {
		return templates;
	}

	public void setTemplates(List<ProductTemplate> templates) {
		this.templates = templates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}
}
