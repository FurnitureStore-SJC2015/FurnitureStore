package com.exposit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.PaymentForm;
import com.exposit.domain.model.PaymentScheme;
import com.exposit.domain.service.PaymentSchemeService;
import com.exposit.repository.dao.PaymentSchemeDao;

@Service
@Transactional
public class PaymentSchemeServiceImpl implements PaymentSchemeService {

	@Autowired
	private PaymentSchemeDao paymentSchemeRepository;

	@Override
	public List<PaymentScheme> getPaymentSchemesByPaymentForm(PaymentForm form) {
		return paymentSchemeRepository.getAllPaymentSchemesByPaymentForm(form);
	}

	@Override
	public PaymentScheme getPaymentSchemeById(Integer id) {
		return paymentSchemeRepository.findById(id);
	}

}
