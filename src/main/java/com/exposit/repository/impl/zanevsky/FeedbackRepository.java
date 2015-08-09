package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.repository.dao.zanevsky.FeedbackDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class FeedbackRepository extends AbstractHibernateDao<Feedback, Integer>
		implements FeedbackDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getFeedacksList(User user) {
		Criteria criteria = this.getSession()
				.createCriteria(Feedback.class, "feedback")
				.add(Restrictions.eq("user", user))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Feedback>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getFeedbackList(ProductCatalogUnit catalogUnit) {
		Criteria criteria = this.getSession().createCriteria(Feedback.class, "feedback")
				.add(Restrictions.eq("productCatalogUnit", catalogUnit));
		return (List<Feedback>) criteria.list();
	}

	@Override
	public Double getAverageMark(ProductCatalogUnit catalogUnit) {
		Criteria criteria = this.getSession().createCriteria(Feedback.class, "feedback")
		.add(Restrictions.eq("productCatalogUnit", catalogUnit))
		.setProjection(Projections.avg("range"));
		return (Double) criteria.uniqueResult();
	}
	
}