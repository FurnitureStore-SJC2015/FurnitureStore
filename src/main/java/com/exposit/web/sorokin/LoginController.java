package com.exposit.web.sorokin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.model.sorokin.User;
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

	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	public String handleLogin(HttpServletRequest request, @RequestParam(
			value = "login", required = true) String login, @RequestParam(
			value = "password", required = true) String password,
			HttpSession httpSession) {
		// TODO AuthenicationException and login exception as parameter
		User user = userService.findUserByLoginAndPassword(login, password);
		httpSession.setAttribute("user", user);
		return "redirect:client/";
	}

	@RequestMapping(value = { "/logout" })
	public ModelAndView logout(HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("login");
		httpSession.setAttribute("user", null);
		httpSession.invalidate();
		return modelAndView;

	}

}
