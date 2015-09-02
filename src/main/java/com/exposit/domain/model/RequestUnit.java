package com.exposit.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request_unit")
public class RequestUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_unit_id")
	private int id;

	@Column(name = "request_module_count")
	private int count;

	@ManyToOne
	@JoinColumn(name = "request_id", nullable = false)
	private Request request;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	private Module module;

	public RequestUnit() {

	}

	public RequestUnit(int count, Module module) {

		this.setModule(module);
		this.setCount(count);
	}

	public RequestUnit(int id, int count, Module module) {
		this.setId(id);
		this.setModule(module);
		this.setCount(count);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
