package com.exposit.web.zanevsky;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/info" })
	public String companyInformation(Model model) {
		model.addAttribute("company", companyService.getCompanyEmployer());
		return "company.info";
	}
}
