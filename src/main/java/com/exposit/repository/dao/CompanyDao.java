package com.exposit.repository.dao;

import com.exposit.domain.model.Company;
import com.exposit.repository.base.GenericDao;

public interface CompanyDao extends GenericDao<Company, Integer> {
	
	public Company getCompanyEmployer();
}
