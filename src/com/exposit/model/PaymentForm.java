package com.exposit.model;

import java.util.List;

public class PaymentForm {

	private int id;
	private PaymentType name;
	private List<PaymentScheme> paymentSchemes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PaymentType getName() {
		return name;
	}

	public void setName(PaymentType name) {
		this.name = name;
	}

	public List<PaymentScheme> getPaymentSchemes() {
		return paymentSchemes;
	}

	public void setPaymentSchemes(List<PaymentScheme> paymentSchemes) {
		this.paymentSchemes = paymentSchemes;
	}

}
