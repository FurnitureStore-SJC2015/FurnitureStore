package com.exposit.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Request;
import com.exposit.domain.model.RequestUnit;
import com.exposit.domain.service.ModuleService;
import com.exposit.domain.service.ProviderService;
import com.exposit.domain.service.RequestService;
import com.exposit.domain.service.StorageModuleUnitService;
import com.exposit.domain.service.UserService;
import com.exposit.web.dto.ModuleDto;
import com.exposit.web.dto.RequestUnitDto;

@Controller
@RequestMapping(value = "/modules", method = RequestMethod.GET)
public class ModuleController {
	@Autowired
	private ModuleService moduleService;

	@Autowired
	private UserService userService;

	@Autowired
	private StorageModuleUnitService storageModuleUnitService;

	@Autowired
	private ProviderService providerService;

	@Autowired
	private RequestService requestService;

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String deleteModuleFromProvider(@PathVariable("id") Integer id,
			Principal principal) {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		moduleService.deleteModuleFromProviderList(id, provider);

		return "modules-list";
	}

	@RequestMapping(value = "/provider/{id}", method = RequestMethod.GET)
	public @ResponseBody List<ModuleDto> getModulesProvider(
			@PathVariable("id") String providerId) {
		List<ModuleDto> modules = new ArrayList<ModuleDto>();
		modules=moduleService.getModulesByProvider(providerService.getProviderById(Integer.parseInt(providerId)));

		return modules;
	}

	@RequestMapping(value = "/provider/add/{id}", method = RequestMethod.POST)
	public String addModuleToProvider(@PathVariable("id") Integer id,
			Principal principal) {
		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		moduleService.addModuleToProviderList(id, provider);

		return "modules-list";

	}

	@RequestMapping(value = "/providers", method = RequestMethod.POST)
	public @ResponseBody List<Provider> getProvidersByModule(
			@RequestBody final Module module, Model model) {
		return providerService.getProviders(module);
	}

	@RequestMapping(value = "/providers/{id}", method = RequestMethod.GET)
	public String getProvidersByModule(@PathVariable("id") Integer id,
			Model model) {

		model.addAttribute("providers",
				providerService.getProviders(moduleService.findById(id)));

		return "module-request";
	}

	@RequestMapping(value = { "", "/" }, method = { RequestMethod.GET })
	public String showProviderModulesPanel(Model model, Principal principal) {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		model.addAttribute("providerId", provider.getId());
		model.addAttribute("modules", moduleService.getModules(provider));
		return "modules-list";
	}

	@RequestMapping(value = { "/catalog" }, method = { RequestMethod.GET })
	public String showModulesCatalog(Model model) {

		model.addAttribute("modules",
				storageModuleUnitService.getStorageModuleUnitDtos());
		return "modules.catalog";
	}

	@RequestMapping(value = "/request/{id}", method = { RequestMethod.GET })
	public String showModuleRequestPanel(@PathVariable("id") Integer id,
			Model model) {
		Module module = moduleService.findById(id);
		model.addAttribute("requestUnit", new RequestUnitDto.Builder()
				.moduleName(module.getModuleType().toString()).moduleId(id));

		model.addAttribute("providers", providerService.getProviders(module));
		return "module-request";

	}

	@RequestMapping(value = { "/request/{id}/send" },
			method = { RequestMethod.POST })
	public String sendRequest(@PathVariable("id") Integer id,
			@Valid RequestUnitDto requestUnitDto, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			Module module = moduleService.findById(id);
			model.addAttribute(
					"requestUnit",
					new RequestUnitDto.Builder().moduleName(
							module.getModuleType().toString()).moduleId(
							module.getId()));

			model.addAttribute("providers",
					providerService.getProviders(module));
			model.addAttribute("error",
					"Check your input, please. Fields must be valid.");
			return "module-request";
		}
		Request request = new Request(new Date(),
				providerService.getProviderByName(requestUnitDto
						.getChosenProvider()));

		RequestUnit requestUnit = new RequestUnit(
				Integer.parseInt(requestUnitDto.getCountString()),
				moduleService.findById(id));
		requestService.saveRequestUnit(requestUnit);
		List<RequestUnit> requestUnits = new ArrayList<RequestUnit>();
		requestUnits.add(requestUnit);

		request.setRequestUnits(requestUnits);
		requestService.saveRequest(request);
		return "request-success";

	}
}