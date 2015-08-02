package com.exposit.domain.model.dobrilko;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exposit.domain.model.zanevsky.Module;

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
}
