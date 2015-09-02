package com.exposit.web.dto.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.Order;
import com.exposit.domain.model.Payment;
import com.exposit.domain.service.PaymentService;
import com.exposit.web.dto.PaymentDto;
import com.exposit.web.dto.service.PaymentDtoService;

@Service
public class PaymentDtoServiceImpl implements PaymentDtoService {

	@Autowired
	private PaymentService paymentService;

	@Override
	public List<PaymentDto> getListOfDtoPayments(Order order) {
		List<Payment> payments = paymentService.getPayments(order);
		List<PaymentDto> paymentsDto = new ArrayList<PaymentDto>();
		for (Payment payment : payments) {
			PaymentDto paymentDto = new PaymentDto(payment,
					paymentService.canBePayed(payment));
			paymentsDto.add(paymentDto);
		}
		return paymentsDto;

	}

}
