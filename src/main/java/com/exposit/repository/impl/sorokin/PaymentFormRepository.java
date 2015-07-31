package com.exposit.repository.impl.sorokin;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.repository.dao.sorokin.PaymentFormDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentFormRepository extends
		AbstractHibernateDao<PaymentForm, Integer> implements PaymentFormDao {

}
