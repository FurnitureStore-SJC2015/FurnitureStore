package com.exposit.web.dobrilko;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping(value = "/provider")
public class ProviderController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String initializeProvider(Authentication auth,
			HttpSession httpSession) {
		Provider provider = (Provider) userService.findUserByName(auth
				.getName());
		httpSession.setAttribute("provider", provider);
		return "redirect:/provider/profile";
	}

	
}
