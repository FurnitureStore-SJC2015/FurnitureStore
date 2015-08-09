package com.exposit.repository.dao.zanevsky;

import java.util.List;

import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.repository.base.GenericDao;

public interface FeedbackDao extends GenericDao<Feedback, Integer>{
	
	public List<Feedback> getFeedacksList(User user);
	
	public List<Feedback> getFeedbackList(ProductCatalogUnit catalogUnit);
	
	public Double getAverageMark(ProductCatalogUnit catalogUnit);
}
