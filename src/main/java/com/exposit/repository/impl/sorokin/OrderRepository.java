package com.exposit.repository.impl.sorokin;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Order;
import com.exposit.repository.dao.sorokin.OrderDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class OrderRepository extends AbstractHibernateDao<Order, Integer>
		implements OrderDao {

}
