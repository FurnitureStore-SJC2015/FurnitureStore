package com.exposit.web.dto.serviceImpl.dobrilko;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.web.dto.converters.dobrilko.ShipmentUnitDtoConverter;
import com.exposit.web.dto.dobrilko.ShipmentUnitDto;
import com.exposit.web.dto.service.dobrilko.ShipmentUnitDtoService;

@Service
public class ShipmentUnitDtoServiceImpl implements ShipmentUnitDtoService {

	@Autowired
	private ShipmentService shipmentService;
	@Autowired
	private ShipmentUnitDtoConverter shipmentUnitDtoConverter;

	@Override
	public List<ShipmentUnitDto> getShipmentUnitsByShipment(Shipment shipment) {
		List<ShipmentUnit> shipmentUnits = shipmentService
				.getShipmentUnitsByShipment(shipment);
		List<ShipmentUnitDto> shipmentUnitDtos = new ArrayList<ShipmentUnitDto>();
		for (ShipmentUnit shipmentUnit : shipmentUnits) {
			shipmentUnitDtos.add(this.shipmentUnitDtoConverter
					.convert(shipmentUnit));
		}
		return shipmentUnitDtos;

	}
}
