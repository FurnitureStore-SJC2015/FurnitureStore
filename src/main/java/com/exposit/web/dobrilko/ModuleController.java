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

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.service.dobrilko.StorageModuleUnitService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.ModuleService;

@Controller
@RequestMapping(value = "/modules", method = RequestMethod.GET)
public class ModuleController {
	@Autowired
	private ModuleService moduleService;

	@Autowired
	private UserService userService;

	@Autowired
	private StorageModuleUnitService storageModuleUnitService;

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
	public String showProviderModulesPanel(Model model, Principal principal) {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());

		model.addAttribute("modules", moduleService.getModules(provider));
		return "modules-list";
	}

	@RequestMapping(value = { "/catalog" }, method = { RequestMethod.GET })
	public String showModulesCatalog(Model model) {

		model.addAttribute("storageModuleUnits",
				storageModuleUnitService.getStorageModuleUnitDtos());
		return "modules-list";
	}

}