package com.exposit.repository.impl.sorokin;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.repository.dao.sorokin.PaymentSchemeDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentSchemeRepository extends
		AbstractHibernateDao<PaymentScheme, Integer> implements
		PaymentSchemeDao {

}
