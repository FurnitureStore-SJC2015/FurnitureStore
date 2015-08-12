package com.exposit.web.dto.serviceImpl.zanevsky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.zanevsky.Company;
import com.exposit.domain.service.zanevsky.CompanyService;
import com.exposit.web.dto.converters.zanevsky.CompanyDtoConverter;
import com.exposit.web.dto.service.zanevsky.CompanyDtoService;
import com.exposit.web.dto.zanevsky.CompanyDto;

@Service
public class CompanyDtoServiceImpl implements CompanyDtoService{

	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyDtoConverter converter;
	
	@Override
	public CompanyDto findById(int id) {
		Company company = this.companyService.findById(id);
		CompanyDto companyDto = this.converter.Convert(company);
		return companyDto;
	}

	@Override
	public CompanyDto getUniqueCompany() {
		Company company = this.companyService.getUniqueCompany();
		CompanyDto companyDto = this.converter.Convert(company);
		return companyDto;
	}

}
