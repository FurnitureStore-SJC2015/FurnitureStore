package com.exposit.repository.impl.dobrilko;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.repository.dao.dobrilko.ShipmentDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ShipmentRepository extends AbstractHibernateDao<Shipment, Integer>
		implements ShipmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Shipment> getShipments(Provider provider)
			throws HibernateException {
		Criteria criteria = getSession().createCriteria(Shipment.class).add(
				Restrictions.eq("provider", provider));
		return (List<Shipment>) criteria.list();
	}

	@Override
	public Shipment getShipment(Waybill waybill) throws HibernateException {
		Criteria criteria = getSession().createCriteria(Shipment.class).add(
				Restrictions.eq("waybill", waybill));
		return (Shipment) criteria.uniqueResult();
	}

	@Override
	public Shipment getShipment(ShipmentUnit shipmentUnit)
			throws HibernateException {

		Criteria criteria = getSession().createCriteria(Shipment.class)
				.createAlias("shipmentUnits", "shUnit")
				.add(Restrictions.eq("shUnit.id", shipmentUnit.getId()));

		return (Shipment) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shipment> getConfirmedShipments(Date beginningDate,
			Date endDate, Provider provider) throws HibernateException {
		Criteria criteria = getSession()
				.createCriteria(Shipment.class)
				.add(Restrictions.eq("provider", provider))
				.createAlias("waybill", "wbll")
				.add(Restrictions.isNotNull("wbll.confirmationDate"))
				.add(Restrictions.between("wbll.confirmationDate",
						beginningDate, endDate));
		return (List<Shipment>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shipment> getNotConfirmedShipments() {
		Criteria criteria = getSession().createCriteria(Shipment.class)
				.createAlias("waybill", "wbll")
				.add(Restrictions.isNull("wbll.confirmationDate"));
		return (List<Shipment>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shipment> getConfirmedShipments(Provider provider) {
		Criteria criteria = getSession().createCriteria(Shipment.class)
				.add(Restrictions.eq("provider", provider))
				.createAlias("waybill", "wbll")
				.add(Restrictions.isNotNull("wbll.confirmationDate"));
		return (List<Shipment>) criteria.list();
	}
}
