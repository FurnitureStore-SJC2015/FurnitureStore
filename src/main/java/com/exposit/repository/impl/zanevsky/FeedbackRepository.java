package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.repository.dao.zanevsky.FeedbackDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class FeedbackRepository extends AbstractHibernateDao<Feedback, Integer>
		implements FeedbackDao {

	@Override
	public List<Feedback> getFeedacksList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> getFeedbackList(ProductCatalogUnit catalogUnit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAverageMark(ProductCatalogUnit catalogUnit) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}