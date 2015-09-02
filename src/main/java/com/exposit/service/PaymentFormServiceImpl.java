package com.exposit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.PaymentForm;
import com.exposit.domain.model.PaymentType;
import com.exposit.domain.service.PaymentFormService;
import com.exposit.repository.dao.PaymentFormDao;

@Service
@Transactional
public class PaymentFormServiceImpl implements PaymentFormService {

	@Autowired
	private PaymentFormDao paymentFormRepository;

	@Override
	public PaymentForm getPaymentFormByPaymentType(PaymentType type) {
		return paymentFormRepository.getPaymentFormByPaymentType(type);
	}

	@Override
	public List<PaymentForm> getAllPaymentForms() {
		return paymentFormRepository.findAll();
	}

	@Override
	public PaymentForm getPaymentFormById(Integer id) {
		return paymentFormRepository.findById(id);
	}

}
