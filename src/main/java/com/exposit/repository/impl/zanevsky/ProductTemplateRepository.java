package com.exposit.repository.impl.zanevsky;

import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.repository.dao.zanevsky.ProductTemplateDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

public class ProductTemplateRepository
		extends AbstractHibernateDao<ProductTemplate, Integer>
		implements ProductTemplateDao {
	
}
