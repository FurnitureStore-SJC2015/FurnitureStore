package com.exposit.web.dobrilko;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.exceptions.CustomException;
import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.ModuleService;

@Controller
@RequestMapping(value = "/provider/modules", method = RequestMethod.GET)
public class ModuleController {
	@Autowired
	private ModuleService moduleService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String deleteModuleFromProvider(@PathVariable("id") Integer id,
			Principal principal) {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		moduleService.deleteModuleFromProviderList(id, provider);

		return "modules-list";
	}

	@RequestMapping(value = { "", "/" }, method = { RequestMethod.GET })
	public String showProviderModulesPanel(Model model, Principal principal)
			throws CustomException {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		model.addAttribute("modules", moduleService.getModules(provider));
		return "modules-list";
	}

}
