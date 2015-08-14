package com.exposit.web.sorokin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exposit.domain.model.sorokin.Role;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.RoleService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.web.dto.sorokin.AdminPanelDto;

@Controller
@RequestMapping(value = "/ajax")
public class AdminAjaxController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping(
			value = { "/panelRequest" },
			method = RequestMethod.POST,
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> processAjaxRequest(@RequestBody Role role) {
		System.out.println("It works!" + role.getName());
		return userService.findAllUsersByRole(role);
	}
}
