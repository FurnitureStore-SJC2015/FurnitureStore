package com.exposit.repository.impl.sorokin;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.repository.dao.sorokin.PaymentSchemeDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentSchemeRepository extends
		AbstractHibernateDao<PaymentScheme, Integer> implements
		PaymentSchemeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentScheme> getAllPaymentSchemesByPaymentForm(
			PaymentForm paymentForm) {
		Criteria cr = getSession().createCriteria(PaymentScheme.class).add(
				Restrictions.eq("paymentType", paymentForm));
		return (List<PaymentScheme>) cr.list();
	}

}
