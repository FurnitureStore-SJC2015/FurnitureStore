package com.exposit.web.sorokin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exposit.domain.model.sorokin.PaymentForm;
import com.exposit.domain.model.sorokin.PaymentScheme;
import com.exposit.domain.service.sorokin.PaymentFormService;
import com.exposit.domain.service.sorokin.PaymentSchemeService;

@Controller
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentFormService paymentFormService;

	@Autowired
	private PaymentSchemeService paymentSchemeService;

	@RequestMapping(value = "/forms", method = RequestMethod.POST)
	public @ResponseBody List<PaymentForm> getAllPaymentForms(Model model) {
		return paymentFormService.getAllPaymentForms();

	}

	@RequestMapping(value = "/schemes", method = RequestMethod.POST)
	public @ResponseBody List<PaymentScheme> getPaymentSchemes(
			@RequestBody final PaymentForm paymentForm, Model model) {
		return paymentSchemeService.getPaymentSchemesByPaymentForm(paymentForm);
	}
}
