package com.exposit.web.sorokin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/login" }, method = { RequestMethod.GET })
	public String showLogin() {
		return "login";
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
