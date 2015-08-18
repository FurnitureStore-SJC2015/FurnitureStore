package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/login" }, method = { RequestMethod.GET })
	public ModelAndView showLogin(@RequestParam(value = "error",
			required = false) String error, @RequestParam(value = "logout",
			required = false) String logout, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		if (error != null) {
			modelAndView.addObject("error", "Invalid user login and password!");
		}
		if (logout != null) {
			modelAndView.addObject("logout",
					"You've been logged out successfully.");
		}

		if (auth != null) {
			modelAndView.setViewName("redirect:/redirector");
		}
		return modelAndView;
	}
}
