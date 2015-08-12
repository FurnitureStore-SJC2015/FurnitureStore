package com.exposit.repository.impl.dobrilko;

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

	@Override
	public Provider getProvider(Request request) {
		Criteria criteria = getSession().createCriteria(Provider.class).add(
				Restrictions.eq("request", request));
		return (Provider) criteria.uniqueResult();
	}

	@Override
	public Provider getProvider(Shipment shipment) {
		Criteria criteria = getSession().createCriteria(Provider.class).add(
				Restrictions.eq("shipment", shipment));
		return (Provider) criteria.uniqueResult();
	}

}
