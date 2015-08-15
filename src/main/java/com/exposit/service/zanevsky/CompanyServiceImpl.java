package com.exposit.service.zanevsky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.zanevsky.Company;
import com.exposit.domain.service.zanevsky.CompanyService;
import com.exposit.repository.dao.zanevsky.CompanyDao;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public Company findById(int id) {
		return companyDao.findById(id);
	}

	@Override
	public Company getUniqueCompany() {
		return companyDao.GetUniqueCompany();
	}
	
	
}
