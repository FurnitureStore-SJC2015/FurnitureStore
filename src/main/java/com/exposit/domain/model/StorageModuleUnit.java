package com.exposit.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "storage_module_unit")
public class StorageModuleUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "storage_module_unit_id")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_delivery")
	private Date dateOfDelivery;

	@OneToOne(mappedBy = "storageModuleUnit")
	@JoinColumn(name = "module_id")
	private Module module;

	@Column(name = "module_count")
	private int count;

	@Column(name = "full_margin")
	private double fullMargin;

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

	public double getFullMargin() {
		return fullMargin;
	}

	public void setFullMargin(double fullMargin) {
		this.fullMargin = fullMargin;
	}

}
