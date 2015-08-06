package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ModuleRepository extends AbstractHibernateDao<Module, Integer>
		implements ModuleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getModules(Provider provider) {
		Criteria criteria = this.getSession().createCriteria(Module.class)
				.add(Restrictions.eq("provider", provider));
		return (List<Module>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getModules(ProductCatalogUnit productCatalogUnit) {
		Criteria criteria = this.getSession().createCriteria(Module.class, "module")
				.createAlias("module.productTemplates", "template")
				.add(Restrictions.eq("template.productCatalogUnit", productCatalogUnit))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Module>) criteria.list();
	}

	@Override
	public Module getModule(StorageModuleUnit storageModuleUnit) {
		Criteria criteria = this.getSession().createCriteria(Module.class, "module")
				.add(Restrictions.eq("storageModuleUnit", storageModuleUnit));
		return (Module) criteria.uniqueResult();
	}

	// ask
	@Override
	public Module getModule(ProductTemplate template) {
		Criteria criteria = this.getSession().createCriteria(Module.class, "module")
				.createCriteria("productTemplates", "product")
				.add(Restrictions.eq("product.id", template.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Module) criteria.uniqueResult();
	}

	@Override
	public Module getModule(ShipmentUnit shipmentUnit) {
		Criteria criteria = this.getSession().createCriteria(Module.class, "module")
				.createCriteria("shipmentUnits", "unit")
				.add(Restrictions.eq("unit.id", shipmentUnit.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Module) criteria.uniqueResult();
	}

	@Override
	public Module getModule(RequestUnit requestUnit) {
		Criteria criteria = this.getSession().createCriteria(Module.class, "module")
				.createCriteria("requestUnits", "unit")
				.add(Restrictions.eq("unit.id", requestUnit.getId()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (Module) criteria.uniqueResult();
	}
	
}
