package com.exposit.repository.impl;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Bonus;
import com.exposit.repository.dao.BonusDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class BonusRepository extends AbstractHibernateDao<Bonus, Integer>
		implements BonusDao {

}
