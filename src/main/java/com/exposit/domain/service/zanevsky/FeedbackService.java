package com.exposit.domain.service.zanevsky;

import java.util.List;

import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;

public interface FeedbackService {
	
	public Feedback findById(int id);
	
	public List<Feedback> getFeedacksList(User user);
	
	public List<Feedback> getFeedbackList(ProductCatalogUnit catalogUnit);
	
	public double getAverageMark(ProductCatalogUnit catalogUnit);
}
