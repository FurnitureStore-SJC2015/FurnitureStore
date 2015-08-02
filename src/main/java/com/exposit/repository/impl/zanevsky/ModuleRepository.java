package com.exposit.repository.impl.zanevsky;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class ModuleRepository extends AbstractHibernateDao<Module, Integer>
		implements ModuleDao {
	
}
