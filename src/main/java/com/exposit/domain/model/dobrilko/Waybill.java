package com.exposit.domain.model.dobrilko;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "waybill")
public class Waybill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "way_bill_id")
	private int id;
	@OneToOne(mappedBy = "waybill")
	private Shipment shipment;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "departure_date")
	private Date departureDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivery_date")
	private Date deliveryDate;
	@Column(name = "delivery_cost")
	private double deliveryCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

}
