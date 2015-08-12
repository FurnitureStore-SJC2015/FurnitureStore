package com.exposit.domain.service.dobrilko;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.Waybill;

public interface ShipmentService {

	public Integer saveShipment(Shipment shipment);

	public Shipment getShipmentByWaybill(Waybill waybill);

	public Shipment getShipmentById(int id);

	public List<Shipment> getShipments();

	public List<Shipment> getShipments(Date beginningDate, Date endDate);

	public void acceptShipment(Shipment shipment, Date confirmantionDate);

	public Shipment getShipment(Waybill waybill);

}
