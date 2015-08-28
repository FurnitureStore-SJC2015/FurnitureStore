package com.exposit.repository.impl.sorokin;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.sorokin.Payment;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.model.sorokin.User;
import com.exposit.repository.dao.sorokin.OrderDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class OrderRepository extends AbstractHibernateDao<Order, Integer>
		implements OrderDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getListOfUserOrders(User user) {
		Criteria cr = getSession().createCriteria(Order.class).add(
				Restrictions.eq("client", user));
		return (List<Order>) cr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getListOfOrdersByPaymentScheme(PaymentScheme scheme) {
		Criteria cr = getSession().createCriteria(Order.class).add(
				Restrictions.eq("paymentScheme", scheme));
		return (List<Order>) cr.list();
	}

	@Override
	public Integer getSizeOfClientOrdersList(User user) {
		Criteria cr = getSession().createCriteria(Order.class)
				.add(Restrictions.eq("client", user))
				.setProjection(Projections.rowCount());
		Long result = (Long) cr.uniqueResult();
		return result.intValue();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getListOfOrdersToConfirm() {
		Criteria cr = getSession().createCriteria(Order.class).add(
				Restrictions.isNull("assemblyDate"));
		return (List<Order>) cr.list();
	}

	@Override
	public Order getOrderByPayment(Payment payment) {
		Criteria cr = getSession().createCriteria(Order.class,"order");
		cr.createCriteria("order.payments","payment");
		cr.add(Restrictions.eq("payment.id", payment.getId()));
		return (Order) cr.uniqueResult();
	}
}
