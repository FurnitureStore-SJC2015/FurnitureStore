package com.exposit.model;

import java.util.Date;
import java.util.List;

public class Order {

	private int id;
	private Date orderDate;
	private Double fullCost;
	private boolean status;
	private Date executionDate;

	private User user;
	private PaymentContract paymentContract;
	private List<OrderUnit> orderUnits;

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

	public PaymentContract getPaymentContract() {
		return paymentContract;
	}

	public void setPaymentContract(PaymentContract paymentContract) {
		this.paymentContract = paymentContract;
	}

	public List<OrderUnit> getOrderUnits() {
		return orderUnits;
	}

	public void setOrderUnits(List<OrderUnit> orderUnits) {
		this.orderUnits = orderUnits;
	}

}
