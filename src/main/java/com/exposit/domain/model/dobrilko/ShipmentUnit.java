package com.exposit.domain.model.dobrilko;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.exposit.domain.model.zanevsky.Module;

public class ShipmentUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shipment_id")
	private int id;
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "module_id") private Module module;
	 */
	@Column(name = "count")
	private int count;
	@Column(name = "cost")
	private double cost;
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "shipment_id")
	private Shipment shipment;

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

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

}
