package com.exposit.web.dobrilko;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.domain.service.dobrilko.ProviderService;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.domain.service.sorokin.UserService;
import com.exposit.web.dto.dobrilko.RequestUnitDto;

@Controller
@RequestMapping(value = "/requests", method = RequestMethod.GET)
public class RequestController {

	@Autowired
	private RequestService requestService;
	@Autowired
	private WaybillService waybillService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private ShipmentService shipmentService;
	@Autowired
	private ProviderService providerService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String showProviderRequestsPanel(Model model, Principal principal) {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		model.addAttribute("requests",
				requestService.getRequestByProvider(provider));
		return "requests-provider";
	}

	@RequestMapping(value = { "/{id}/process" }, method = RequestMethod.POST)
	public String processRequest(
			@PathVariable("id") Request request,

			@RequestParam(value = "delivery-date", required = true) Date deliveryDate,
			@RequestParam(value = "provider-margin-percent", required = true) Integer providerMarginPercent,
			@RequestParam(value = "delivery-cost", required = true) Double deliveryCost,
			Model model) {

		model.addAttribute("request", request);
		requestService.processRequest(request, deliveryDate,
				providerMarginPercent, deliveryCost);
		return "request-processing";
	}

	@RequestMapping(value = { "/{id}/processing_page" },
			method = RequestMethod.GET)
	public String showProcessingPage(@PathVariable("id") Request request,

	Model model) {

		model.addAttribute("request", request);
		return "request-processing";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showRequest(@PathVariable("id") Request request,

	Model model) {
		model.addAttribute("request", request);

		model.addAttribute("requestUnits", requestService
				.convertRequestUnitsToDto(requestService
						.getRequestUnitsByRequest(request)));
		return "request-info";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String makeRequest(@PathVariable("id") Integer moduleId, Model model) {

		model.addAttribute("moduleId", moduleId);
		return "request.new";

	}

	@RequestMapping(value = "/order/${id}", method = { RequestMethod.GET })
	public String showModuleRequestPanel(@PathVariable("id") Integer id,
			Model model) {
		model.addAttribute("requestUnitDtos",
				requestService.createRequestUnitDtos(id));
		return "module-order-request";

	}

	@RequestMapping(value = { "/order/${id}/send" },
			method = { RequestMethod.POST })
	public String sendOrderRequest(@PathVariable("id") Integer id, Model model) {
		requestService.sendRequests(id);
		return "request-success";

	}

	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	public String makeRequestForOrder(
			@RequestParam(value = "order") Order order, Model model) {

		model.addAttribute("requestUnits",
				requestService.convertOrderToRequestUnitsDto(order));
		return "request.order";

	}
}
