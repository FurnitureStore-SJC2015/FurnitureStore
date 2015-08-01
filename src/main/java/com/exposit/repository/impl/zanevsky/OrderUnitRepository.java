package com.exposit.repository.impl.zanevsky;

import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.repository.dao.zanevsky.OrderUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

public class OrderUnitRepository
		extends AbstractHibernateDao<OrderUnit, Integer>implements OrderUnitDao {
	
}
