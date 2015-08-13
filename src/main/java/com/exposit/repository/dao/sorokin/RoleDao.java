package com.exposit.repository.dao.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.RoleType;
import com.exposit.repository.base.GenericDao;

public interface RoleDao extends GenericDao<Role, Integer> {

	public Role getRoleByRoleType(RoleType roleType);

	public List<Role> getAllRolesButAdmin();
}
