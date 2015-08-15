package com.exposit.web.sorokin;

import javax.servlet.http.HttpSession;

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
			required = false) String error, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "Invalid user login and password!");
		}
		if (auth != null) {
			modelAndView.setViewName("redirect:/redirector");
			return modelAndView;
		}

		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = { "/logout" })
	public ModelAndView logout(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("redirect:login");
		httpSession.setAttribute("client", null);
		httpSession.invalidate();
		return modelAndView;
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String redirectIfLoggedIn(Authentication auth) {
		if (auth != null) {
			return "redirect:/redirector";
		} else
			return "redirect:/login";
	}

}
