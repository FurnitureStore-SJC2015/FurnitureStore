package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.RoleType;

public interface RoleService {

	public List<Role> getAllRoles();

	public Role getRoleById(Integer id);

	public List<Role> getAllRolesButAdmin();

	public Role getRoleByRoleType(RoleType roleType);
}
