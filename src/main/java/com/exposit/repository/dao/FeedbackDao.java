package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Feedback;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.User;
import com.exposit.repository.base.GenericDao;

public interface FeedbackDao extends GenericDao<Feedback, Integer>{
	
	public List<Feedback> getFeedacksList(User user);
	
	public List<Feedback> getFeedbackList(ProductCatalogUnit catalogUnit);
	
	public double getAverageMark(ProductCatalogUnit catalogUnit);
}
