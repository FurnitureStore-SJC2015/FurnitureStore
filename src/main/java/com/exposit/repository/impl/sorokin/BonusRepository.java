package com.exposit.repository.impl.sorokin;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Bonus;
import com.exposit.repository.dao.sorokin.BonusDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class BonusRepository extends AbstractHibernateDao<Bonus, Integer>
		implements BonusDao {

	@Override
	public Bonus getCurrentDefaultBonus() {
		Criteria cr = getSession().createCriteria(Bonus.class).add(
				Restrictions.eq("flag", true));
		return (Bonus) cr.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bonus> getSuitableBonuses(Double currentSum) {
		Criteria cr = getSession().createCriteria(Bonus.class).add(
				Restrictions.le("sumBound", currentSum));
		return (List<Bonus>) cr.list();
	}

}
