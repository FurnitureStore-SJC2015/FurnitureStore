package com.exposit.web.sorokin;

import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.RoleType;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.MailService;
import com.exposit.domain.service.sorokin.RoleService;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private MailService mailService;

	@RequestMapping(value = "", method = { RequestMethod.GET })
	public String indexPage() {
		return "redirect:/admin/panel";
	}

	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public String showListOfUsers(Model model) {
		model.addAttribute("roleList", roleService.getAllRolesButAdmin());
		return "admin.panel";
	}

	@RequestMapping(value = "/panel", method = { RequestMethod.POST })
	public String processAdminPanel(Model model, RedirectAttributes attributes,
			@RequestParam("id") Role role) {
		attributes.addFlashAttribute("userList",
				userService.findAllUsersByRole(role));
		return "redirect:panel";

	}

	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
	public String processUser(@PathVariable("id") User user, Model model) {
		userService.deleteUser(user);
		return "admin.panel";
	}

	@RequestMapping(value = "/register/provider", method = RequestMethod.GET)
	public String showRegisterFormForProvider(Model model) {
		model.addAttribute("provider", new Provider());
		return "admin.register";
	}

	@RequestMapping(value = "/register/provider", method = RequestMethod.POST)
	public String registerNewProvider(@Valid Provider provider,
			BindingResult result) {
		if (result.hasErrors()) {
			return "admin.register";
		}
		registerNewProvider(provider);
		return "admin.panel";
	}

	private void registerNewProvider(Provider provider) {
		String password = RandomStringUtils.randomAlphabetic(8);
		String cryptedPassword = encoder.encode(password);
		provider.setRole(roleService.getRoleByRoleType(RoleType.PROVIDER));
		provider.setPassword(cryptedPassword);
		userService.createNewUser(provider);
		mailService.sendRegistrationMail(provider.getLogin(), password,
				provider.getEmail());
	}

}
