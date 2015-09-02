package com.exposit.web.dto.service;

import java.util.List;

import com.exposit.domain.model.Order;
import com.exposit.web.dto.PaymentDto;

public interface PaymentDtoService {

	public List<PaymentDto> getListOfDtoPayments(Order order);
}
