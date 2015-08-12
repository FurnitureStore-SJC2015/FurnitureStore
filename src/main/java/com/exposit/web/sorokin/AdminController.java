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

import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.User;
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
	public String handleRequest(Model model, RedirectAttributes attributes) {
		model.addAttribute("roleList", roleService.getAllRoles());
		return "admin.index";
	}

	@RequestMapping(value = { "/panel" }, method = { RequestMethod.POST })
	public String processAdminPanel(Model model, RedirectAttributes attributes,
			@RequestParam("id") Role role) {
		attributes.addFlashAttribute("userList",
				userService.findAllUsersByRole(role));
		return "redirect:/admin";

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
	public ModelAndView processUser(@PathVariable("id") User user) {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
}
