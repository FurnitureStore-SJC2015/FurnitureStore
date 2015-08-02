package com.exposit.repository.impl.dobrilko;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.repository.dao.dobrilko.ProviderDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ProviderRepository extends AbstractHibernateDao<Provider, Integer>
		implements ProviderDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Request> getRequestsByProvider(Provider provider) {
		Criteria criteria = getSession().createCriteria(Request.class).add(
				Restrictions.eq("provider", provider));
		return (List<Request>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shipment> getShipmentsByProvider(Provider provider) {
		Criteria criteria = getSession().createCriteria(Shipment.class).add(
				Restrictions.eq("provider", provider));
		return (List<Shipment>) criteria.list();
	}

}
