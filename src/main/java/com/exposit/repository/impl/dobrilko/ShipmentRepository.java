package com.exposit.repository.impl.dobrilko;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.repository.dao.dobrilko.ShipmentDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ShipmentRepository extends AbstractHibernateDao<Shipment, Integer>
		implements ShipmentDao {

}
