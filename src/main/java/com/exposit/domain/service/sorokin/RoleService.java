package com.exposit.domain.service.sorokin;

import java.util.List;

import com.exposit.domain.model.sorokin.Role;

public interface RoleService {

	public List<Role> getAllRoles();

	public Role getRoleById(Integer id);
}
