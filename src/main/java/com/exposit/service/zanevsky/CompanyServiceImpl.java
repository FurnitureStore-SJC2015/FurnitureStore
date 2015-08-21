package com.exposit.service.zanevsky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.sorokin.RoleType;
import com.exposit.domain.model.zanevsky.Company;
import com.exposit.domain.service.zanevsky.CompanyService;
import com.exposit.repository.dao.sorokin.RoleDao;
import com.exposit.repository.dao.sorokin.UserDao;

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
