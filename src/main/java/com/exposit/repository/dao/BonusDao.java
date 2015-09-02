package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Bonus;
import com.exposit.repository.base.GenericDao;

public interface BonusDao extends GenericDao<Bonus, Integer> {

	public Bonus getCurrentDefaultBonus();

	public List<Bonus> getSuitableBonuses(Double currentSum);
}
