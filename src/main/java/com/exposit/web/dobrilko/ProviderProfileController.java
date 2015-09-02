package com.exposit.web.dobrilko;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.domain.service.dobrilko.ProviderService;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping(value = "/provider/profile")
public class ProviderProfileController {

	@Autowired
	private ProviderService providerService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PriceService priceService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showProviderProfile(Model model, Principal principal) {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		Date date  = new Date();
		model.addAttribute("values", priceService.calculateYearGain(provider));
		model.addAttribute("year", date.getYear()+1900);
		return "profile-provider";
	}
	
	

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEditProvderProfileForm(Authentication auth, Model model) {
		model.addAttribute("provider", new Provider());
		return "provider.profile.edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEditChanges(@Valid Provider editedProvider,
			BindingResult result,
			@RequestParam(value = "avatar") MultipartFile avatar,
			Authentication auth) {
		if (result.hasErrors()) {
			return "provider.profile.edit";
		}
		Provider loggedProvider = (Provider) userService.findUserByName(auth
				.getName());
		providerService
				.setChangedFields(loggedProvider, editedProvider, avatar);
		userService.updateUser(loggedProvider);
		return "redirect:/provider";
	}

}
