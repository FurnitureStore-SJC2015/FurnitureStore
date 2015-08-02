package com.exposit.repository.impl.dobrilko;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.repository.dao.dobrilko.StorageModuleUnitDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class StorageModuleUnitRepository extends
		AbstractHibernateDao<StorageModuleUnit, Integer> implements
		StorageModuleUnitDao {

}
