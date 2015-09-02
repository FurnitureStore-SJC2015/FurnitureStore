package com.exposit.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ProductTemplate;
import com.exposit.domain.model.Provider;
import com.exposit.domain.model.RequestUnit;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.repository.dao.ModuleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ModuleRepository extends AbstractHibernateDao<Module, Integer>
		implements ModuleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getModules(Provider provider) {

		Criteria criteria = this.getSession().createCriteria(Module.class)
				.createAlias("providers", "aliasProvider")
				.add(Restrictions.eq("aliasProvider.id", provider.getId()));
		return (List<Module>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getModules(ProductCatalogUnit productCatalogUnit) {
		Criteria criteria = this
				.getSession()
				.createCriteria(Module.class, "module")
				.createAlias("module.productTemplates", "template")
				.add(Restrictions.eq("template.productCatalogUnit",
						productCatalogUnit))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Module>) criteria.list();
	}

	@Override
	public Module getModule(StorageModuleUnit storageModuleUnit) {
		Criteria criteria = this.getSession()
				.createCriteria(Module.class, "module")
				.add(Restrictions.eq("storageModuleUnit", storageModuleUnit));
		return (Module) criteria.uniqueResult();
	}

	@Override
	public Module getModule(ProductTemplate template) {

		Criteria c = getSession().createCriteria(Module.class, "module");
		c.createAlias("module.productTemplates", "template");
		c.add(Restrictions.eq("template.id", template.getId()));
		return (Module) c.uniqueResult();

	}

	@Override
	public Module getModule(ShipmentUnit shipmentUnit) {
		Criteria criteria = this.getSession()
				.createCriteria(Module.class, "module")
				.createCriteria("shipmentUnits", "unit")
				.add(Restrictions.eq("unit.id", shipmentUnit.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Module) criteria.uniqueResult();
	}

	@Override
	public Module getModule(RequestUnit requestUnit) {
		Criteria criteria = this.getSession()
				.createCriteria(Module.class, "module")
				.createCriteria("requestUnits", "unit")
				.add(Restrictions.eq("unit.id", requestUnit.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Module) criteria.uniqueResult();
	}

}
