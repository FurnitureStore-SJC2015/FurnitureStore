package com.exposit.web.dobrilko;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.domain.service.sorokin.UserService;

@Controller
@RequestMapping(value = "/reports", method = RequestMethod.GET)
public class ReportController {
	@Autowired
	private RequestService requestService;
	@Autowired
	private WaybillService waybillService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "/" }, method = { RequestMethod.GET })
	public String showReportsPanel() {

		return "report-management-page";
	}

	@RequestMapping(value = { "/filtered" }, method = { RequestMethod.GET })
	public ModelAndView showFilteredReports(@RequestParam(value = "daterange",
			required = true) String daterange, Principal principal) {

		Provider provider = (Provider) userService
				.findUserByName(((UserDetails) ((Authentication) principal)
						.getPrincipal()).getUsername());
		ModelAndView mav = new ModelAndView();

		mav.addObject("shipments",
				shipmentService.getConfirmedShipments(daterange, provider));
		mav.setViewName("report-management-page");

		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showRequest(@PathVariable("id") Shipment shipment,

	Model model) {
		model.addAttribute("shipment", shipment);
		model.addAttribute("shipmentUnits", shipmentService
				.convertShipmentUnitsToDto(shipmentService
						.getShipmentUnitsByShipment(shipment)));
		return "shipment-info";
	}

	@RequestMapping(value = "/{id}/waybill", method = RequestMethod.GET)
	public String showWaybill(@PathVariable("id") Shipment shipment,

	Model model) {

		model.addAttribute("waybill",
				waybillService.getWaybillByShipment(shipment));

		return "waybill-info";
	}
}
