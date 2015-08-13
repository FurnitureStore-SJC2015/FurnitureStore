package com.exposit.repository.impl.sorokin;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.RoleType;
import com.exposit.repository.dao.sorokin.RoleDao;
import com.exposit.repository.hibernate.AbstractHibernateDao;

@Repository()
public class RoleRepository extends AbstractHibernateDao<Role, Integer>
		implements RoleDao {

	@Override
	public Role getRoleByRoleType(RoleType roleType) {
		Criteria cr = getSession().createCriteria(Role.class).add(
				Restrictions.eq("name", roleType));
		return (Role) cr.uniqueResult();
	}

	@Override
	public List<Role> getAllRolesButAdmin() {
		Criteria cr = getSession().createCriteria(Role.class).add(
				Restrictions.ne("name", RoleType.ADMIN));
		return cr.list();
	}
}
