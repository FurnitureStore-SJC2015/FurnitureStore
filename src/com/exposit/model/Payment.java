package com.exposit.model;

import java.util.Date;

public class Payment {

	private int id;
	private Date date;
	private Double sum;
	private PaymentContract paymentContract;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public PaymentContract getPaymentContract() {
		return paymentContract;
	}

	public void setPaymentContract(PaymentContract paymentContract) {
		this.paymentContract = paymentContract;
	}

}
