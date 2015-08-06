package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userRepository;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String showAdminPanel(Model model) {
		model.addAttribute("usr", userRepository.getUserById(9));
		model.addAttribute("userList", userRepository.getUsers());
		return "adminPanel";
	}
}
