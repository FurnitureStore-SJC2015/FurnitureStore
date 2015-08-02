package com.exposit.repository.impl.zanevsky;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.repository.dao.zanevsky.ProductTemplateDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ProductTemplateRepository
		extends AbstractHibernateDao<ProductTemplate, Integer>
		implements ProductTemplateDao {
	
}
