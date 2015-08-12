package com.exposit.domain.service.zanevsky;

import com.exposit.domain.model.zanevsky.Company;

public interface CompanyService {
	
	public Company findById(int id);
	
	public Company getUniqueCompany();
}
