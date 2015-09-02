package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.User;

public interface FeedbackService {

	public Feedback findById(int id);

	public List<Feedback> getFeedacksList(User user);

	public List<Feedback> getFeedbackList(ProductCatalogUnit catalogUnit);

	public double getAverageMark(ProductCatalogUnit catalogUnit);

	public void addNewFeedback(Feedback feedback);
}
