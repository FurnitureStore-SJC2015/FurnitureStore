package com.exposit.repository.impl.dobrilko;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ShipmentUnitRepository extends
		AbstractHibernateDao<ShipmentUnit, Integer> implements ShipmentUnitDao {

}
