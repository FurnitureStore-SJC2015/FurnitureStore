package com.exposit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.User;
import com.exposit.domain.service.FeedbackService;
import com.exposit.repository.dao.FeedbackDao;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDao feedbackRepository;

	@Override
	public Feedback findById(int id) {
		return this.feedbackRepository.findById(id);
	}

	@Override
	public List<Feedback> getFeedacksList(User user) {
		return this.feedbackRepository.getFeedacksList(user);
	}

	@Override
	public List<Feedback> getFeedbackList(ProductCatalogUnit catalogUnit) {
		return this.feedbackRepository.getFeedbackList(catalogUnit);
	}

	@Override
	public double getAverageMark(ProductCatalogUnit catalogUnit) {
		return this.feedbackRepository.getAverageMark(catalogUnit);
	}

	@Override
	public void addNewFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);

	}

}
