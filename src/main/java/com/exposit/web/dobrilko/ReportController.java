package com.exposit.web.dobrilko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.web.dto.service.dobrilko.RequestUnitDtoService;
import com.exposit.web.dto.service.dobrilko.ShipmentUnitDtoService;

@Controller
@RequestMapping(value = "/provider/reports", method = RequestMethod.GET)
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
	private RequestUnitDtoService requestUnitDtoService;
	@Autowired
	private ShipmentUnitDtoService shipmentUnitDtoService;

	@RequestMapping(value = { "", "/" }, method = { RequestMethod.GET })
	public String showReportsPanel(Model model) {

		model.addAttribute("shipments", shipmentService.getConfirmedShipments());
		return "report-management-page";
	}

	@RequestMapping(value = { "/filtered" }, method = { RequestMethod.GET })
	public ModelAndView showFilteredReports(@RequestParam(value = "daterange",
			required = true) String daterange) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("shipments",
				shipmentService.getConfirmedShipments(daterange));
		mav.setViewName("report-management-page");

		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showRequest(@PathVariable("id") Shipment shipment,

	Model model) {
		model.addAttribute("shipment", shipment);
		model.addAttribute("shipmentUnits",
				shipmentUnitDtoService.getShipmentUnitsByShipment(shipment));
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
