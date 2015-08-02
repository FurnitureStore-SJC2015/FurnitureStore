package com.exposit.repository.impl.dobrilko;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RequestRepository extends AbstractHibernateDao<Request, Integer>
		implements RequestDao {

	@Override
	public Provider getProviderByRequest(Request request) {
		Criteria criteria = getSession().createCriteria(Provider.class).add(
				Restrictions.eq("request", request));
		return (Provider) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestUnit> getRequestUnitsByRequest(Request request) {
		Criteria criteria = getSession().createCriteria(RequestUnit.class).add(
				Restrictions.eq("request", request));
		return (List<RequestUnit>) criteria.list();
	}

}
