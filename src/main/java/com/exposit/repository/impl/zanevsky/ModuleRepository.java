package com.exposit.repository.impl.zanevsky;

import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

public class ModuleRepository extends AbstractHibernateDao<Module, Integer>
		implements ModuleDao {
	
}
