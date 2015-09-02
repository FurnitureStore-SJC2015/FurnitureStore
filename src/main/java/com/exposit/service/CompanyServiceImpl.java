package com.exposit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Company;
import com.exposit.domain.model.RoleType;
import com.exposit.domain.service.CompanyService;
import com.exposit.repository.dao.RoleDao;
import com.exposit.repository.dao.UserDao;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private UserDao userRepository;

	@Autowired
	private RoleDao roleRepostiory;

	@Override
	public Company getCompanyEmployer() {
		return (Company) userRepository.getListOfAllUsersByRole(
				roleRepostiory.getRoleByRoleType(RoleType.COMPANY)).get(0);
	}
}
