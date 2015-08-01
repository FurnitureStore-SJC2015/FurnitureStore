package com.exposit.repository.dao.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.repository.base.GenericDao;

public interface PaymentSchemeDao extends GenericDao<PaymentScheme, Integer> {
	public List<PaymentScheme> getAllPaymentSchemesByPaymentForm(
			PaymentForm paymentForm);
}
