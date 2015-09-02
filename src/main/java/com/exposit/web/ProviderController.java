package com.exposit.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exposit.domain.model.Provider;
import com.exposit.domain.service.ModuleService;
import com.exposit.domain.service.ProviderService;
import com.exposit.domain.service.UserService;

@Controller
@RequestMapping(value = "/provider")
public class ProviderController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProviderService providerService;
	@Autowired
	private ModuleService moduleService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String initializeProvider(Authentication auth,
			HttpSession httpSession) {
		Provider provider = (Provider) userService.findUserByName(auth
				.getName());
		httpSession.setAttribute("provider", provider);
		return "redirect:/provider/profile";
	}

	

}
