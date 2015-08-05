package com.exposit.repository.impl.zanevsky;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.Provider;
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
				.add(Restrictions.eq("template.productCatalogUnit", productCatalogUnit));
		return (List<Module>) criteria.list();
	}

	@Override
	public Module getModule(StorageModuleUnit storageModuleUnit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module getModule(ProductTemplate template) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module getModule(ShipmentUnit shipmentUnit) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
