package com.exposit.repository.dao.zanevsky;

import com.exposit.domain.model.zanevsky.Company;
import com.exposit.repository.base.GenericDao;

public interface CompanyDao extends GenericDao<Company, Integer> {
	
	public Company GetUniqueCompany();
}
