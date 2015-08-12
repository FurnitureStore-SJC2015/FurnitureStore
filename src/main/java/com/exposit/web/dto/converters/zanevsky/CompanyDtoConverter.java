package com.exposit.web.dto.converters.zanevsky;

import org.springframework.stereotype.Component;

import com.exposit.domain.model.zanevsky.Company;
import com.exposit.web.dto.zanevsky.CompanyDto;

@Component
public class CompanyDtoConverter {
	
	public CompanyDto Convert(Company company) {
		CompanyDto dto = new CompanyDto();
		dto.setAddress(company.getAddress());
		dto.setDescription(company.getDescription());
		dto.setDirector(company.getDirector());
		dto.setEmail(company.getEmail());
		dto.setZip(company.getZip());
		dto.setCompanyName(company.getCompanyName());
		return dto;
	}
}
