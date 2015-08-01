package com.exposit.repository.dao.sorokin;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.domain.model.sorokin.PaymentType;
import com.exposit.repository.base.GenericDao;

public interface PaymentFormDao extends GenericDao<PaymentForm, Integer> {

	public PaymentForm getPaymentFormByPaymentType(PaymentType type);
}
