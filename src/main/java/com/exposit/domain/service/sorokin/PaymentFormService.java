package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.domain.model.sorokin.PaymentType;

public interface PaymentFormService {

	public PaymentForm getPaymentFormByPaymentType(PaymentType type);

	public List<PaymentForm> getAllPaymentForms();

	public PaymentForm getPaymentFormById(Integer id);
}
