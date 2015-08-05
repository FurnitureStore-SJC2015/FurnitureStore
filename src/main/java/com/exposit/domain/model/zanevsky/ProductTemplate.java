package com.exposit.domain.model.zanevsky;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_template")
public class ProductTemplate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "product_template_id")
	private int id;

	@Basic(fetch = FetchType.EAGER)
	@Column(name = "modules_number", nullable = false)
	private int count;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable = false)
	private Module module;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_catalog_unit_id", nullable = false)
	private ProductCatalogUnit productCatalogUnit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ProductCatalogUnit getProductCatalogUnit() {
		return productCatalogUnit;
	}

	public void setProductCatalogUnit(ProductCatalogUnit productCatalogUnit) {
		this.productCatalogUnit = productCatalogUnit;
	}

}
