package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.repository.dao.zanevsky.ProductTemplateDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ProductTemplateRepository
		extends AbstractHibernateDao<ProductTemplate, Integer>
		implements ProductTemplateDao {

	@Override
	public List<ProductTemplate> getProductTemlplatesList(
			ProductCatalogUnit catalogUnit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductTemplate getProductTemplate(Module module) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
