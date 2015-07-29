package com.exposit.repository.impl;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.PaymentForm;
import com.exposit.repository.dao.PaymentFormDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentFormRepository extends
		AbstractHibernateDao<PaymentForm, Integer> implements PaymentFormDao {

}
