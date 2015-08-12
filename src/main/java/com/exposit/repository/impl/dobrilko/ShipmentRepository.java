package com.exposit.repository.impl.dobrilko;

import java.util.List;

import org.hibernate.Criteria;
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
	public List<Shipment> getShipments(Provider provider) {
		Criteria criteria = getSession().createCriteria(Shipment.class).add(
				Restrictions.eq("provider", provider));
		return (List<Shipment>) criteria.list();
	}

	@Override
	public Shipment getShipment(Waybill waybill) {
		Criteria criteria = getSession().createCriteria(Shipment.class).add(
				Restrictions.eq("waybill", waybill));
		return (Shipment) criteria.uniqueResult();
	}

	@Override
	public Shipment getShipment(ShipmentUnit shipmentUnit) {
		Criteria criteria = getSession().createCriteria(Shipment.class).add(
				Restrictions.eq("shipmentUnit", shipmentUnit));
		return (Shipment) criteria.uniqueResult();
	}

}
