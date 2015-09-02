package com.exposit.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.PaymentForm;
import com.exposit.domain.model.PaymentType;
import com.exposit.repository.dao.PaymentFormDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentFormRepository extends
		AbstractHibernateDao<PaymentForm, Integer> implements PaymentFormDao {

	@Override
	public PaymentForm getPaymentFormByPaymentType(PaymentType type) {
		Criteria cr = getSession().createCriteria(PaymentForm.class).add(
				Restrictions.eq("name", type));
		return (PaymentForm) cr.uniqueResult();
	}
}
