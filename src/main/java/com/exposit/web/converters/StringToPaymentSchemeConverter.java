package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.service.sorokin.PaymentSchemeService;

public class StringToPaymentSchemeConverter implements
		Converter<String, PaymentScheme> {

	@Autowired
	private PaymentSchemeService paymentSchemeService;

	@Override
	public PaymentScheme convert(String id) {
		return paymentSchemeService.getPaymentSchemeById(Integer.valueOf(id));
	}

}
