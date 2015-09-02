package com.exposit.web.dto.dobrilko;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RequestProcessDto {

	@Max(value = 1000, message="*value must be less than 1000")
	@Min(value = 0, message="*value must be greater than 0")
	private double deliveryCost;
	@Max(value = 100, message="*value must be less than 100")
	@Min(value = 0, message="*value must be greater than 0")
	private int providerMarginPercent;
	@Future( message="*date must be in future")
	private Date deliveryDate;

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getProviderMarginPercent() {
		return providerMarginPercent;
	}

	public void setProviderMarginPercent(int providerMarginPercent) {
		this.providerMarginPercent = providerMarginPercent;
	}

}
