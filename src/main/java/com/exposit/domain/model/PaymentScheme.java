package com.exposit.domain.model;

import java.util.Date;
import java.util.List;

public class PaymentScheme {

	private int id;
	private Date term;
	private PaymentForm paymentType;
	private List<Order> orders;
	private Date cycle;
	private double penalty;
	private double percentage;

	public Date getCycle() {
		return cycle;
	}

	public void setCycle(Date cycle) {
		this.cycle = cycle;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTerm() {
		return term;
	}

	public void setTerm(Date term) {
		this.term = term;
	}

	public PaymentForm getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentForm paymentType) {
		this.paymentType = paymentType;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
