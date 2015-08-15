package com.exposit.service.zanevsky;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.zanevsky.FeedbackService;
import com.exposit.repository.dao.zanevsky.FeedbackDao;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDao feedbackDao;

	@Override
	public Feedback findById(int id) {
		return this.feedbackDao.findById(id);
	}
	
	@Override
	public List<Feedback> getFeedacksList(User user) {
		return this.feedbackDao.getFeedacksList(user);
	}

	@Override
	public List<Feedback> getFeedbackList(ProductCatalogUnit catalogUnit) {
		return this.feedbackDao.getFeedbackList(catalogUnit);
	}

	@Override
	public double getAverageMark(ProductCatalogUnit catalogUnit) {
		return this.feedbackDao.getAverageMark(catalogUnit);
	}

}
