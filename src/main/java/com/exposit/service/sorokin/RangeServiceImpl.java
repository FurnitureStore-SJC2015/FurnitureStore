package com.exposit.service.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.sorokin.RangeService;
import com.exposit.domain.service.zanevsky.FeedbackService;

@Service
@Transactional
public class RangeServiceImpl implements RangeService {

	@Autowired
	private FeedbackService feedbackService;

	@Override
	public double countRange(ProductCatalogUnit product) {
		double range = 0;
		double feedbackCount = feedbackService.getFeedbackList(product).size();
		if (feedbackCount != 0) {
			for (Feedback feedback : feedbackService.getFeedbackList(product)) {
				range += feedback.getRange();
			}
			return range / feedbackCount;
		} else
			return 0;
	}
}
