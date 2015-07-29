package com.exposit.repository.impl;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Payment;
import com.exposit.repository.dao.PaymentDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentRepository extends AbstractHibernateDao<Payment, Integer>
		implements PaymentDao {

}
