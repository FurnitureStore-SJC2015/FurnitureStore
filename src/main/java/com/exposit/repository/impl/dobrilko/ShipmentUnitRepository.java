package com.exposit.repository.impl.dobrilko;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ShipmentUnitRepository extends
		AbstractHibernateDao<ShipmentUnit, Integer> implements ShipmentUnitDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ShipmentUnit> getShipmentUnits(Shipment shipment) {
		Criteria criteria = getSession().createCriteria(ShipmentUnit.class)
				.add(Restrictions.eq("shipment", shipment));
		return (List<ShipmentUnit>) criteria.list();
	}

}
