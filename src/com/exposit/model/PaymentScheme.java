package com.exposit.model;

import java.util.Date;
import java.util.List;

public class PaymentScheme {

	private int id;
	private Date term;

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

	public List<PaymentContract> getPaymentContracts() {
		return paymentContracts;
	}

	public void setPaymentContracts(List<PaymentContract> paymentContracts) {
		this.paymentContracts = paymentContracts;
	}

	private PaymentForm paymentType;
	private List<PaymentContract> paymentContracts;
}
