package com.exposit.repository.impl.sorokin;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Bonus;
import com.exposit.repository.dao.sorokin.BonusDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class BonusRepository extends AbstractHibernateDao<Bonus, Integer>
		implements BonusDao {

}
