package com.exposit.repository.impl.dobrilko;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RequestRepository extends AbstractHibernateDao<Request, Integer>
		implements RequestDao {

	@Transactional
	@Override
	public Request getRequest(RequestUnit requestUnit) {
		Criteria criteria = getSession().createCriteria(Request.class).add(
				Restrictions.eq("requestUnit", requestUnit));
		return (Request) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Request> getRequests(Provider provider) {
		Criteria criteria = getSession().createCriteria(Request.class).add(
				Restrictions.eq("provider", provider));
		return (List<Request>) criteria.list();
	}
}
