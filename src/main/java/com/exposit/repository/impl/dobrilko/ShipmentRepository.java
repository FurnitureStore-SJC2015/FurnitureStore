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

	@Override
	public Waybill getWaybillByShipment(Shipment shipment) {
		Criteria criteria = getSession().createCriteria(Waybill.class).add(
				Restrictions.eq("shipment", shipment));
		return (Waybill) criteria.uniqueResult();
	}

	@Override
	public Provider getProviderByShipment(Shipment shipment) {
		Criteria criteria = getSession().createCriteria(Provider.class).add(
				Restrictions.eq("shipment", shipment));
		return (Provider) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentUnit> getShipmentUnitsByShipment(Shipment shipment) {
		Criteria criteria = getSession().createCriteria(ShipmentUnit.class)
				.add(Restrictions.eq("shipment", shipment));
		return (List<ShipmentUnit>) criteria.list();
	}

}
