package com.exposit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ProductTemplate;
import com.exposit.domain.service.ProductTemplateService;
import com.exposit.repository.dao.ModuleDao;
import com.exposit.repository.dao.ProductTemplateDao;

@Service
@Transactional
public class ProductTemplateServiceImpl implements ProductTemplateService {

	@Autowired
	ModuleDao moduleRepository;
	@Autowired
	ProductTemplateDao productTemplateDao;

	@Override
	public List<ProductTemplate> getEmptyProductTemplatesList() {
		List<Module> modules = this.moduleRepository.findAll();
		List<ProductTemplate> templates = new ArrayList<ProductTemplate>();
		for (Module module : modules) {
			templates.add(this.makeTemplate(module, 0));
		}
		return templates;
	}

	private ProductTemplate makeTemplate(Module module, int count) {
		ProductTemplate template = new ProductTemplate();
		template.setModule(module);
		if (module.getProductTemplates() == null)
			module.setProductTemplates(new ArrayList<ProductTemplate>());
		// module.getProductTemplates().add(template);
		template.setCount(count);
		return template;
	}

	@Override
	public List<ProductTemplate> getProductTemplates(
			ProductCatalogUnit productCatalogUnit) {
		return productTemplateDao.getProductTemplatesList(productCatalogUnit);
	}
}
