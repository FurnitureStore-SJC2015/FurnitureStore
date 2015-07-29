package com.exposit.repository.impl;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Order;
import com.exposit.repository.dao.OrderDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class OrderRepository extends AbstractHibernateDao<Order, Integer>
		implements OrderDao {

}
