package com.exposit.web.dobrilko;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/provider/profile")
public class ProviderProfileController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showProviderProfile() {
		return "profile-provider";
	}

}
