package com.exposit.domain.service.sorokin;

import com.exposit.domain.model.sorokin.Bonus;

public interface BonusService {

	public Bonus getCurrentDefaultBonus();

	public Bonus getCuitableBonus(Double totalSpent);
}
