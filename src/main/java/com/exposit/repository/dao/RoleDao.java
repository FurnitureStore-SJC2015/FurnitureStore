package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Role;
import com.exposit.domain.model.RoleType;
import com.exposit.repository.base.GenericDao;

public interface RoleDao extends GenericDao<Role, Integer> {

	public Role getRoleByRoleType(RoleType roleType);

	public List<Role> getAllRolesButAdmin();
}
