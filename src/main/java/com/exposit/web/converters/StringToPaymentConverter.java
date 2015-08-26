package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.service.sorokin.PaymentService;

@Component
public class StringToPaymentConverter implements Converter<String, Payment> {

	@Autowired
	private PaymentService paymentService;

	@Override
	public Payment convert(String id) {
		return paymentService.getPaymentById(Integer.valueOf(id));
	}

}
