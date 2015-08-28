package com.exposit.repository.impl.dobrilko;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.dao.dobrilko.StorageModuleUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class StorageModuleUnitRepository extends
		AbstractHibernateDao<StorageModuleUnit, Integer> implements
		StorageModuleUnitDao {

	@Override
	public StorageModuleUnit getStorageModuleUnit(Module module) {

		Criteria criteria = this.getSession().createCriteria(StorageModuleUnit.class)
				.createAlias("module", "mdl")
				.add(Restrictions.eq("mdl.id", module.getId()));
		
		return (StorageModuleUnit) criteria.uniqueResult();
	}

}
