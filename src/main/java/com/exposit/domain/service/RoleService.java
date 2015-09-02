package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.Role;
import com.exposit.domain.model.RoleType;

public interface RoleService {

	public List<Role> getAllRoles();

	public Role getRoleById(Integer id);

	public List<Role> getAllRolesButAdmin();

	public Role getRoleByRoleType(RoleType roleType);
}
