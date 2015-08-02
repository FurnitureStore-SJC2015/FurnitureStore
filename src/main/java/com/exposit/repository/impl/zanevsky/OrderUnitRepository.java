package com.exposit.repository.impl.zanevsky;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.repository.dao.zanevsky.OrderUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class OrderUnitRepository
		extends AbstractHibernateDao<OrderUnit, Integer>implements OrderUnitDao {
	
}
