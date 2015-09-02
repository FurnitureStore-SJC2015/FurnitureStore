package com.exposit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exposit.domain.model.Client;
import com.exposit.domain.model.Payment;
import com.exposit.domain.model.PaymentForm;
import com.exposit.domain.model.PaymentScheme;
import com.exposit.domain.service.BonusService;
import com.exposit.domain.service.PaymentFormService;
import com.exposit.domain.service.PaymentSchemeService;
import com.exposit.domain.service.PaymentService;
import com.exposit.domain.service.UserService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentFormService paymentFormService;

	@Autowired
	private PaymentSchemeService paymentSchemeService;

	@Autowired
	private UserService userService;

	@Autowired
	private BonusService bonusService;

	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/forms", method = RequestMethod.POST)
	public @ResponseBody List<PaymentForm> getAllPaymentForms(Model model) {
		return paymentFormService.getAllPaymentForms();

	}

	@RequestMapping(value = "/schemes", method = RequestMethod.POST)
	public @ResponseBody List<PaymentScheme> getPaymentSchemes(
			@RequestBody final PaymentForm paymentForm, Model model) {
		return paymentSchemeService.getPaymentSchemesByPaymentForm(paymentForm);
	}

	@RequestMapping(value = "/{id}/pay", method = RequestMethod.POST)
	public String processPayment(@PathVariable("id") Payment payment,
			Authentication auth) {
		Client client = (Client) userService.findUserByName(auth.getName());
		client.setTotalSpent(payment.getSum());
		client.setBonus(bonusService.getCuitableBonus(client.getTotalSpent()));
		payment.setPaymentStatus(true);
		paymentService.updatePayment(payment);
		userService.updateUser(client);
		return "redirect:/order/all";

	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String showFuturePayments(Model model, Authentication auth) {
		Client client = (Client) userService.findUserByName(auth.getName());
		model.addAttribute("payments",
				paymentService.getFururePaymentNotifications(client));
		return "client.payments";
	}
}
