package com.exposit.domain.model;

import java.util.Date;
import java.util.List;

public class Order {

	private int id;
	private Date orderDate;
	private Double fullCost;
	private boolean status;
	private Date executionDate;

	private User user;
	private List<Payment> payments;
	private PaymentScheme paymentScheme;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getFullCost() {
		return fullCost;
	}

	public void setFullCost(Double fullCost) {
		this.fullCost = fullCost;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public PaymentScheme getPaymentScheme() {
		return paymentScheme;
	}

	public void setPaymentScheme(PaymentScheme paymentScheme) {
		this.paymentScheme = paymentScheme;
	}

}
