package com.exposit.service.sorokin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.service.sorokin.PaymentSchemeService;
import com.exposit.repository.dao.sorokin.PaymentSchemeDao;

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
