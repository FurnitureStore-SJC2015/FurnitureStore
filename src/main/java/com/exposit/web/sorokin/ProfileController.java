package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	public UserService userRepository;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showProfile() {
		//ModelAndView modelAndView = new ModelAndView();
		return "profile";
	}
}
