package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.PaymentForm;
import com.exposit.domain.model.PaymentScheme;
import com.exposit.repository.base.GenericDao;

public interface PaymentSchemeDao extends GenericDao<PaymentScheme, Integer> {
	public List<PaymentScheme> getAllPaymentSchemesByPaymentForm(
			PaymentForm paymentForm);
}
