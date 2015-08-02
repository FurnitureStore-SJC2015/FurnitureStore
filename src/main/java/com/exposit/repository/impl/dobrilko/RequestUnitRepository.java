package com.exposit.repository.impl.dobrilko;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RequestUnitRepository extends
		AbstractHibernateDao<RequestUnit, Integer> implements RequestUnitDao {

}
