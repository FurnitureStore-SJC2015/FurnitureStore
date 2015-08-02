package com.exposit.repository.impl.dobrilko;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ShipmentUnitRepository extends
		AbstractHibernateDao<ShipmentUnit, Integer> implements ShipmentUnitDao {

	@Override
	public Module getModuleByShipmentUnit(ShipmentUnit shipmentUnit) {
		Criteria criteria = getSession().createCriteria(Module.class).add(
				Restrictions.eq("shipmentUnit", shipmentUnit));
		return (Module) criteria.uniqueResult();
	}

	@Override
	public Shipment getShipmentByShipmentUnit(ShipmentUnit shipmentUnit) {
		Criteria criteria = getSession().createCriteria(Shipment.class).add(
				Restrictions.eq("shipmentUnit", shipmentUnit));
		return (Shipment) criteria.uniqueResult();
	}

}
