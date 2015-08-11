package com.exposit.repository.impl.dobrilko;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RequestUnitRepository extends
		AbstractHibernateDao<RequestUnit, Integer> implements RequestUnitDao {

	@Override
	public Request getRequestByRequestUnit(RequestUnit requestUnit) {
		Criteria criteria = getSession().createCriteria(Request.class).add(
				Restrictions.eq("requestUnit", requestUnit));
		return (Request) criteria.uniqueResult();
	}

	@Override
	public Module getModuleByRequestUnit(RequestUnit requestUnit) {
		Criteria criteria = getSession().createCriteria(Module.class).add(
				Restrictions.eq("requestUnit", requestUnit));
		return (Module) criteria.uniqueResult();
	}

}
