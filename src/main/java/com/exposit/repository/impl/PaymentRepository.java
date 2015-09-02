package com.exposit.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Client;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.Payment;
import com.exposit.repository.dao.PaymentDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class PaymentRepository extends AbstractHibernateDao<Payment, Integer>
		implements PaymentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getListOfAllPayments(Order order) {
		Criteria cr = getSession().createCriteria(Payment.class).add(
				Restrictions.eq("order", order));
		return (List<Payment>) cr.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getFuturePayments(Client client) {
		Criteria cr = getSession().createCriteria(Payment.class, "payment");
		cr.createCriteria("payment.order", "order");
		cr.createCriteria("order.client", "client");
		cr.add(Restrictions.eq("client.id", client.getId()));
		cr.setMaxResults(5);
		cr.addOrder(org.hibernate.criterion.Order.asc("date"));
		cr.add(Restrictions.eq("paymentStatus", false));
		cr.add(Restrictions
				.between("date", new Date(),
						new DateTime(new Date()).plusDays(30).toDate()));
		return cr.list();
	}
}
