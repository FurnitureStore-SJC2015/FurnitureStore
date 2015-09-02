package com.exposit.web.dto;

import com.exposit.domain.model.Payment;

public class PaymentDto {

	private Payment payment;

	private Boolean canBePayed;

	public PaymentDto(Payment payment, Boolean canBePayed) {
		this.payment = payment;
		this.canBePayed = canBePayed;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Boolean getCanBePayed() {
		return canBePayed;
	}

	public void setCanBePayed(Boolean canBePayed) {
		this.canBePayed = canBePayed;
	}

}
