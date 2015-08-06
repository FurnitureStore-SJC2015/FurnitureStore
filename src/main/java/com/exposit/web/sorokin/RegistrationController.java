package com.exposit.web.sorokin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exposit.domain.model.sorokin.User;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userRepository;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String doRegistration(@Valid User user, BindingResult result,
			RedirectAttributes redirectAttributes) {
		String resultView = "redirect:/login";
		if (result.hasErrors()) {
			return "register";
		}
		userRepository.createNewUser(user);
		redirectAttributes.addFlashAttribute("new_user", user);// TODO
		return resultView;
	}
}
