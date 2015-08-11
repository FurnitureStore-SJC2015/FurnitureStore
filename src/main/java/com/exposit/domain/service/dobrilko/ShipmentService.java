package com.exposit.domain.service.dobrilko;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.Waybill;

public interface ShipmentService {

	public Integer createShipment(Request request, Shipment shipment);

	public Integer createWaybill(Waybill waybill);

}
