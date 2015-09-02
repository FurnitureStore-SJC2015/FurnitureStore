package com.exposit.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.Waybill;
import com.exposit.repository.dao.WaybillDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class WaybillRepository extends AbstractHibernateDao<Waybill, Integer>
		implements WaybillDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Waybill> getWaybills(Date beginningDate, Date endDate) {
		Criteria criteria = getSession().createCriteria(Waybill.class).add(
				(Restrictions.between("confirmationDate", beginningDate,
						endDate)));
		return (List<Waybill>) criteria.list();
	}

	@Override
	public Waybill getWaybill(Shipment shipment) {
		Criteria criteria = getSession().createCriteria(Waybill.class).add(
				Restrictions.eq("shipment", shipment));
		return (Waybill) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Waybill> getConfirmedWaybills(Date beginningDate, Date endDate) {
		Criteria criteria = getSession()
				.createCriteria(Waybill.class)
				.add((Restrictions.isNotNull("confirmationDate")))
				.add(Restrictions.between("confirmationDate", beginningDate,
						endDate));
		return (List<Waybill>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Waybill> getConfirmedWaybills() {
		Criteria criteria = getSession().createCriteria(Waybill.class).add(
				(Restrictions.isNotNull("confirmationDate")));
		return (List<Waybill>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Waybill> getConfirmedWaybills(Date beginningDate, Date endDate,
			Provider provider) {
		
		Criteria criteria = getSession()
				.createCriteria(Waybill.class).add(Restrictions.eq("provider", provider))
				.add((Restrictions.isNotNull("confirmationDate")))
				.add(Restrictions.between("confirmationDate", beginningDate,
						endDate));
		return (List<Waybill>) criteria.list();
	}
}
