package com.exposit.repository.impl.zanevsky;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.zanevsky.Status;
import com.exposit.repository.dao.zanevsky.StatusDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class StatusRepository extends AbstractHibernateDao<Status, Integer>
		implements StatusDao {

}
