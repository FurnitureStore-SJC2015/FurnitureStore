package com.exposit.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Request;
import com.exposit.domain.model.RequestUnit;
import com.exposit.repository.dao.RequestUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RequestUnitRepository extends
		AbstractHibernateDao<RequestUnit, Integer> implements RequestUnitDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestUnit> getRequestUnits(Request request) {
		Criteria criteria = getSession().createCriteria(RequestUnit.class).add(
				Restrictions.eq("request", request));
		return (List<RequestUnit>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RequestUnit> getRequestUnits(Module module) {
		Criteria criteria = getSession().createCriteria(RequestUnit.class)
				.createAlias("module", "mdl")
				.add(Restrictions.eq("mdl.id", module.getId()));
		return (List<RequestUnit>) criteria.list();
	}

}
