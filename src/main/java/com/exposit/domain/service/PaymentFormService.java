package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.PaymentForm;
import com.exposit.domain.model.PaymentType;

public interface PaymentFormService {

	public PaymentForm getPaymentFormByPaymentType(PaymentType type);

	public List<PaymentForm> getAllPaymentForms();

	public PaymentForm getPaymentFormById(Integer id);
}
