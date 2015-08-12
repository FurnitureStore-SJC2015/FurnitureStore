package com.exposit.web.dto.service.zanevsky;

import com.exposit.web.dto.zanevsky.CompanyDto;

public interface CompanyDtoService {
	
	public CompanyDto findById(int id);
	
	public CompanyDto getUniqueCompany();
}
