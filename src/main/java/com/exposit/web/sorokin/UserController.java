package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/" })
	public ModelAndView message() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("users", userService.getUsers());
		mav.setViewName("home_page");
		return mav;
	}
}
