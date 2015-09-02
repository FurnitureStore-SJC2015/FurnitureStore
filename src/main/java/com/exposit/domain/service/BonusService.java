package com.exposit.domain.service;

import com.exposit.domain.model.Bonus;

public interface BonusService {

	public Bonus getCurrentDefaultBonus();

	public Bonus getCuitableBonus(Double totalSpent);
}
