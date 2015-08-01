package com.exposit.repository.dao.sorokin;

import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.RoleType;
import com.exposit.repository.base.GenericDao;

public interface RoleDao extends GenericDao<Role, Integer> {

	public Role getRoleByRoleType(RoleType roleType);
}
