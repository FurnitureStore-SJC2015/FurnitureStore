package com.exposit.repository.impl.sorokin;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.domain.model.sorokin.PaymentType;
import com.exposit.repository.dao.sorokin.PaymentFormDao;
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
