package com.exposit.repository.impl;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.PaymentScheme;
import com.exposit.repository.dao.PaymentSchemeDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentSchemeRepository extends
		AbstractHibernateDao<PaymentScheme, Integer> implements
		PaymentSchemeDao {

}
