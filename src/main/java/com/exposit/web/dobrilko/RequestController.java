package com.exposit.web.dobrilko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.service.dobrilko.RequestService;

@Controller
@RequestMapping(value = "/requests", method = RequestMethod.GET)
public class RequestController {

	@Autowired
	private RequestService requestService;

	@RequestMapping(value = "/provider_panel", method = RequestMethod.GET)
	public ModelAndView showProviderRequestsPanel() {

		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
