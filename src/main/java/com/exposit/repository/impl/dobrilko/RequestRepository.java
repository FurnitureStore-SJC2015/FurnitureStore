package com.exposit.repository.impl.dobrilko;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RequestRepository extends AbstractHibernateDao<Request, Integer>
		implements RequestDao {

}
