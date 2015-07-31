package com.exposit.repository.impl.sorokin;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Role;
import com.exposit.repository.dao.sorokin.RoleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RoleRepository extends AbstractHibernateDao<Role, Integer>
		implements RoleDao {

}
