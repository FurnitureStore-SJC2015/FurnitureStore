package com.exposit.repository.impl.sorokin;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Payment;
import com.exposit.repository.dao.sorokin.PaymentDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentRepository extends AbstractHibernateDao<Payment, Integer>
		implements PaymentDao {

}
