package com.exposit.domain.model.dobrilko;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exposit.domain.model.zanevsky.Module;

@Entity
@Table(name = "shipment_unit")
public class ShipmentUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shipment_unit_id")
	private int id;

	@Column(name = "count")
	private int count;

	@Column(name = "cost")
	private double cost;
	
	@Column (name = "provider_margin_percent")
	private int providerMarginPercent;

	@ManyToOne
	@JoinColumn(name = "module_id")
	private Module module;

	@ManyToOne
	@JoinColumn(name = "shipment_id")
	private Shipment shipment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

}
