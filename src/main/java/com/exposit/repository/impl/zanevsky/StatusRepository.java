package com.exposit.repository.impl.zanevsky;

import com.exposit.domain.model.zanevsky.Status;
import com.exposit.repository.dao.zanevsky.StatusDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

public class StatusRepository extends AbstractHibernateDao<Status, Integer>
		implements StatusDao {

}
