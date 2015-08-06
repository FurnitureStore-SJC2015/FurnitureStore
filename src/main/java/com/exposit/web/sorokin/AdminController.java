package com.exposit.web.sorokin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userRepository;

	@RequestMapping(value = { "", "/" })
	public String showAdminPanel() {
		return "adminProfile";
	}
}
