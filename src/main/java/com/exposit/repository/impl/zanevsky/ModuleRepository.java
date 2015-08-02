package com.exposit.repository.impl.zanevsky;

import java.util.List;

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

	@Override
	public List<Module> getModules(Provider provider) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Module> getModules(ProductCatalogUnit productCatalogUnit) {
		// TODO Auto-generated method stub
		return null;
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
