package com.exposit.repository.impl.zanevsky;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.repository.dao.zanevsky.FeedbackDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class FeedbackRepository extends AbstractHibernateDao<Feedback, Integer>
		implements FeedbackDao {
	
}