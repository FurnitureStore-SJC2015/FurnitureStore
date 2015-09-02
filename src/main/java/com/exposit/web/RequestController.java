package com.exposit.web;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Request;
import com.exposit.domain.service.ModuleService;
import com.exposit.domain.service.PriceService;
import com.exposit.domain.service.ProviderService;
import com.exposit.domain.service.RequestService;
import com.exposit.domain.service.ShipmentService;
import com.exposit.domain.service.UserService;
import com.exposit.domain.service.WaybillService;
import com.exposit.web.dto.RequestProcessDto;
import com.exposit.web.dto.RequestUnitDto;

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
	private ModuleService moduleService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String showProviderRequestsPanel(Model model, Principal principal) {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		model.addAttribute("requests",
				requestService.getNotProcessedRequests(provider));
		return "requests-provider";
	}

	@RequestMapping(value = { "/{id}/process" }, method = RequestMethod.POST)
	public String processRequest(@PathVariable("id") Request request,
			@Valid RequestProcessDto requestProcessDto,
			BindingResult bindingResult, Model model, Principal principal) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("request", request);
			model.addAttribute("requestProcessDto", requestProcessDto);
			return "request-processing";
		}
		model.addAttribute("request", request);
		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		requestService.processRequest(request,
				requestProcessDto.getDeliveryDate(),
				requestProcessDto.getProviderMarginPercent(),
				requestProcessDto.getDeliveryCost(),
				providerService.getProviderById(provider.getId()));
		return "shipment.success";
	}

	@RequestMapping(value = { "/{id}/processing_page" },
			method = RequestMethod.GET)
	public String showProcessingPage(@PathVariable("id") Request request,

	Model model) {

		model.addAttribute("request", request);
		model.addAttribute("requestProcessDto", new RequestProcessDto());
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

	@RequestMapping(value = { "/order/${id}/send" },
			method = { RequestMethod.POST })
	public String sendOrderRequest(@PathVariable("id") Integer id, Model model) {
		requestService.sendRequests(id);
		return "request-success";

	}

	@RequestMapping(value = "/order/send", method = RequestMethod.POST)
	public @ResponseBody String sendRequestFromOrder(
			@RequestBody RequestUnitDto requestUnitDto) {

		requestService.sendRequestFromRequestUnitDto(requestUnitDto);
		return "success";

	}

	@RequestMapping(value = "/providers", method = RequestMethod.GET)
	public @ResponseBody List<Provider> getProvidersByModule(
			@RequestParam String text) {
		List<Provider> providers = new ArrayList<Provider>();
		if (text != null) {
			providers = providerService.getProviders(moduleService
					.findById(Integer.parseInt(text)));
		}
		return providers;
	}

	@RequestMapping(value = { "/order/{id}" }, method = RequestMethod.POST)
	public String makeRequestForOrder(
			@PathVariable(value = "id") Integer orderId, Model model) {

		model.addAttribute("requestUnitDtos",
				requestService.createRequestUnitDtos(orderId));
		return "request.order";

	}
}
