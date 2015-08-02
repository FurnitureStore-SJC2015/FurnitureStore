package com.exposit.repository.impl.dobrilko;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.repository.dao.dobrilko.WaybillDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;


@Repository()
public class WaybillRepository extends AbstractHibernateDao<Waybill, Integer>
		implements WaybillDao {

}
