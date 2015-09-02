package com.exposit.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Request;
import com.exposit.domain.model.RequestUnit;
import com.exposit.repository.dao.RequestDao;
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
	public List<Request> getNotProcessedRequests(Provider provider){
		Criteria criteria = getSession().createCriteria(Request.class).add(
				Restrictions.eq("provider", provider)).add(Restrictions.eq("isProcessed", false));
		return (List<Request>) criteria.list();
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
