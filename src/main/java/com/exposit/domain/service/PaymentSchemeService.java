package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.PaymentForm;
import com.exposit.domain.model.PaymentScheme;

public interface PaymentSchemeService {

	public List<PaymentScheme> getPaymentSchemesByPaymentForm(PaymentForm form);

	public PaymentScheme getPaymentSchemeById(Integer id);

}
