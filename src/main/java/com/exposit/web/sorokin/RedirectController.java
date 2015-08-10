package com.exposit.web.sorokin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.sorokin.User;

@Controller
@RequestMapping("/redirector")
public class RedirectController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String redirect(HttpSession session) {
		User user = (User) session.getAttribute("user");
		String test = user.getRole().getName().toString().toLowerCase() + "/";
		return "" + user.getRole().getName().toString().toLowerCase() + "/";
	}
}
