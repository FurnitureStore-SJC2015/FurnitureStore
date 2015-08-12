package com.exposit.web.sorokin;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute("client", new Client());
		return "register";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String doRegistration(@Valid Client client, BindingResult result,
			RedirectAttributes redirectAttributes, @RequestParam(
					value = "image") MultipartFile avatar) {
		String resultView = "redirect:/login";
		if (result.hasErrors()) {
			return "register";
		}
		//String cryptedPassword = encoder.encode(client.getPassword());
		client.setPassword(client.getPassword());
		try {
			client.setAvatar(avatar.getBytes());
		} catch (IOException e) {
			e.getStackTrace();
		}
		userService.createNewUser(client);
		redirectAttributes.addFlashAttribute("new_client", client);
		return resultView;
	}
}
