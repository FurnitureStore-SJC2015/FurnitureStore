package com.exposit.web.dobrilko;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.web.dto.service.dobrilko.RequestUnitDtoService;

@Controller
@RequestMapping(value = "/provider/module_requests", method = RequestMethod.GET)
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
	private RequestUnitDtoService requestUnitDtoService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String showProviderRequestsPanel(Model model) {

		model.addAttribute("requests", requestService.getAllRequests());
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
		model.addAttribute("requestUnits",
				requestUnitDtoService.getRequestUnitsByRequest(request));
		return "request-info";
	}

}
