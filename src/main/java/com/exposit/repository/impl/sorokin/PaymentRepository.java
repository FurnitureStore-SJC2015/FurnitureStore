package com.exposit.repository.impl.sorokin;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.repository.dao.sorokin.PaymentDao;
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
	public List<Payment> getFuturePayments() {
		Criteria cr = getSession().createCriteria(Payment.class);
		cr.setMaxResults(3);
		cr.add(Restrictions.between("date", new Date(),
				new DateTime(new Date()).plusDays(30).toDate()));
		return cr.list();
	}
}
