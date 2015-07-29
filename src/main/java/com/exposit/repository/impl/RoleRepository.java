package com.exposit.repository.impl;

import org.springframework.stereotype.Repository;

import com.exposit.domain.model.Role;
import com.exposit.repository.dao.RoleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RoleRepository extends AbstractHibernateDao<Role, Integer>
		implements RoleDao {

}
