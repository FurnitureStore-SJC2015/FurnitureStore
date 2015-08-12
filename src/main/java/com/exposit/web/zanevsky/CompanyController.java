package com.exposit.web.zanevsky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exposit.web.dto.service.zanevsky.CompanyDtoService;
import com.exposit.web.dto.zanevsky.CompanyDto;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyDtoService companyService;
	
	@RequestMapping(value = {"/", "/info"})
	public String companyInformation(Model model){
		CompanyDto company = companyService.getUniqueCompany();
		model.addAttribute("company", company);
		return "company.info";
	}
}
