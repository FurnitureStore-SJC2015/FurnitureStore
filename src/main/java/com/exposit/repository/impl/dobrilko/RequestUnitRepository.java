package com.exposit.repository.impl.dobrilko;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;
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

}
