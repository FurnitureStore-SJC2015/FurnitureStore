package com.exposit.repository.dao;

import com.exposit.domain.model.PaymentForm;
import com.exposit.domain.model.PaymentType;
import com.exposit.repository.base.GenericDao;

public interface PaymentFormDao extends GenericDao<PaymentForm, Integer> {

	public PaymentForm getPaymentFormByPaymentType(PaymentType type);
}
