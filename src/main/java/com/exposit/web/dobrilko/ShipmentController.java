package com.exposit.web.dobrilko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;

@Controller
@RequestMapping(value = "/provider/shipments", method = RequestMethod.GET)
public class ShipmentController {

	@Autowired
	private RequestService requestService;
	@Autowired
	private WaybillService waybillService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private ShipmentService shipmentService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String showShipmentsAcceptancePanel(Model model) {
		model.addAttribute("shipments", shipmentService.getShipments());

		return "shipment-acceptance";
	}

}
