package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.Shipment;
import com.exposit.domain.service.ShipmentService;

@Component
public class StringToShipmentConverter implements Converter<String, Shipment> {

	@Autowired
	private ShipmentService shipmentService;

	@Override
	public Shipment convert(String shipmentId) {
		return shipmentService.getShipmentById(Integer.parseInt(shipmentId));
	}
}
