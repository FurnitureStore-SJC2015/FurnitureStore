package com.exposit.repository.impl.dobrilko;

import java.util.Date;
import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Waybill> getWaybills(Date beginningDate, Date endDate) {
		Criteria criteria = getSession().createCriteria(Waybill.class).add(
				(Restrictions.between("arrival_date", beginningDate, endDate)));
		return (List<Waybill>) criteria.list();
	}

	@Override
	public Waybill getWaybill(Shipment shipment) {
		Criteria criteria = getSession().createCriteria(Waybill.class).add(
				Restrictions.eq("shipment", shipment));
		return (Waybill) criteria.uniqueResult();
	}
}
