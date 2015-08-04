package com.exposit.web.sorokin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/" })
	public ModelAndView message() {
		ModelAndView mav = new ModelAndView("users");
		List<User> users = userService.getUsers();
		mav.addObject("listOfUsers", users);
		return mav;
	}
}
