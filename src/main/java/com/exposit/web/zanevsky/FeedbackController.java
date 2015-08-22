package com.exposit.web.zanevsky;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposit.domain.model.sorokin.Client;
import com.exposit.domain.model.zanevsky.Feedback;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.domain.service.zanevsky.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addFeedback(@RequestParam("message") String message,
			@RequestParam("range") Integer range,
			@RequestParam("productId") ProductCatalogUnit product,
			Authentication auth, Model model) {
		Client client = (Client) userService.findUserByName(auth.getName());
		Feedback feedback = new Feedback();
		feedback.setClient(client);
		feedback.setDate(new Date());
		feedback.setText(message);
		feedback.setProductCatalogUnit(product);
		feedback.setRange(range);
		feedbackService.addNewFeedback(feedback);
		return "redirect:/catalog/product/" + product.getId();
	}

}
