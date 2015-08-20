package com.exposit.web.sorokin;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showProfile() {
		return "client.profile";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEditProfileForm(Authentication auth, Model model) {
		model.addAttribute("client", new Client());
		return "client.profile.edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveEditChanges(@Valid Client editedClient,
			BindingResult result,
			@RequestParam(value = "image") MultipartFile avatar,
			Authentication auth) {
		if (result.hasErrors()) {
			return "client.profile.edit";
		}
		Client loggedClient = (Client) userService.findUserByName(auth.getName());
		setChangedFields(loggedClient, editedClient, avatar);
		userService.updateUser(loggedClient);
		return "redirect:/client";
	}

	private void setChangedFields(Client loggedClient, Client editedClient,
			MultipartFile avatar) {
		loggedClient.setEmail(editedClient.getEmail());
		loggedClient.setPassword(encoder.encode(editedClient.getPassword()));
		if (avatar != null) {
			try {
				loggedClient.setAvatar(avatar.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
