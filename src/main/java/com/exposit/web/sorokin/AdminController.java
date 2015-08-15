package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.model.zanevsky.Company;
import com.exposit.domain.service.sorokin.RoleService;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "", method = { RequestMethod.GET })
	public String indexPage() {
		return "admin.index";
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

}
