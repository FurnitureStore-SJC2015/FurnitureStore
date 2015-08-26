package com.exposit.web.dto.service;

import java.util.List;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.web.dto.sorokin.PaymentDto;

public interface PaymentDtoService {

	public List<PaymentDto> getListOfDtoPayments(Order order);
}
