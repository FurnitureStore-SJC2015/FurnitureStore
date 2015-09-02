package com.exposit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Bonus;
import com.exposit.domain.service.BonusService;
import com.exposit.repository.dao.BonusDao;

@Service
@Transactional
public class BonusServiceImpl implements BonusService {

	@Autowired
	private BonusDao bonusRepository;

	@Override
	public Bonus getCurrentDefaultBonus() {
		return bonusRepository.getCurrentDefaultBonus();
	}

	@Override
	public Bonus getCuitableBonus(Double totalSpent) {
		if (bonusRepository.getSuitableBonuses(totalSpent).size()!=0) {
			List<Bonus> suitableBonuses = bonusRepository
					.getSuitableBonuses(totalSpent);
			return suitableBonuses.get(suitableBonuses.size() - 1);
		} else
			return bonusRepository.getCurrentDefaultBonus();
	}
}
