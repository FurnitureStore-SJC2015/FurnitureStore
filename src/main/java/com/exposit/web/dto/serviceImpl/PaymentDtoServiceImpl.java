package com.exposit.web.dto.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.service.sorokin.PaymentService;
import com.exposit.web.dto.service.PaymentDtoService;
import com.exposit.web.dto.sorokin.PaymentDto;

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
