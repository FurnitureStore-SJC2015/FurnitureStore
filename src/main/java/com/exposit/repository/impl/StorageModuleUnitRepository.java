package com.exposit.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.repository.dao.StorageModuleUnitDao;
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
