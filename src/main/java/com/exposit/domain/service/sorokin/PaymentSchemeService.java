package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.domain.model.sorokin.PaymentScheme;

public interface PaymentSchemeService {

	public List<PaymentScheme> getPaymentSchemesByPaymentForm(PaymentForm form);

	public PaymentScheme getPaymentSchemeById(Integer id);

}
