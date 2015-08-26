package com.exposit.service.sorokin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.Bonus;
import com.exposit.domain.service.sorokin.BonusService;
import com.exposit.repository.dao.sorokin.BonusDao;

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
		if (bonusRepository.getSuitableBonuses(totalSpent) != null) {
			List<Bonus> suitableBonuses = bonusRepository
					.getSuitableBonuses(totalSpent);
			return suitableBonuses.get(suitableBonuses.size() - 1);
		} else
			return bonusRepository.getCurrentDefaultBonus();
	}
}
