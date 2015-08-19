package com.exposit.web.dto.service.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.web.dto.dobrilko.ShipmentUnitDto;

public interface ShipmentUnitDtoService {

	public List<ShipmentUnitDto> getShipmentUnitsByShipment(Shipment shipment);
}
