package com.exposit.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.OrderUnit;
import com.exposit.domain.model.Status;
import com.exposit.repository.dao.StatusDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class StatusRepository extends AbstractHibernateDao<Status, Integer>
		implements StatusDao {

	@Override
	public Status getStatus(OrderUnit orderUnit) {
		Criteria criteria = this.getSession().createCriteria(Status.class, "status")
				.createAlias("status.orderUnits", "unit")
				.add(Restrictions.eq("unit.id", orderUnit.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Status) criteria.uniqueResult();
	}

}
