package com.exposit.domain.model.dobrilko;

import com.exposit.domain.model.zanevsky.Module;

public class StorageModuleUnit {
	private int id;
	/* private Module module; */
	private int count;
	private double cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public Module getModule() { return module; }
	 * 
	 * public void setModule(Module module) { this.module = module; }
	 */

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
