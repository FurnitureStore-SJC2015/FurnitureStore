package com.exposit.repository.impl.dobrilko;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.repository.dao.dobrilko.WaybillDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class WaybillRepository extends AbstractHibernateDao<Waybill, Integer>
		implements WaybillDao {

	@Override
	public Shipment getShipmentByWaybill(Waybill waybill) {
		Criteria criteria = getSession().createCriteria(Shipment.class).add(
				Restrictions.eq("waybill", waybill));
		return (Shipment) criteria.uniqueResult();
	}

}
