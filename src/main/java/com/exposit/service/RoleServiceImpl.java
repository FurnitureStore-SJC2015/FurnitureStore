package com.exposit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Role;
import com.exposit.domain.model.RoleType;
import com.exposit.domain.service.RoleService;
import com.exposit.repository.dao.RoleDao;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleRepository;

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();

	}

	@Override
	public Role getRoleById(Integer id) {
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> getAllRolesButAdmin() {
		return roleRepository.getAllRolesButAdmin();
	}

	@Override
	public Role getRoleByRoleType(RoleType roleType) {
		return roleRepository.getRoleByRoleType(roleType);
	}

}
