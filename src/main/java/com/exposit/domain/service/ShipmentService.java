package com.exposit.domain.service;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.Waybill;
import com.exposit.web.dto.ShipmentUnitDto;

public interface ShipmentService {

	public Integer saveShipment(Shipment shipment);

	public Integer saveShipmentUnit(ShipmentUnit shipmentUnit);

	public Shipment getShipmentByWaybill(Waybill waybill);

	public Shipment getShipmentById(int id);

	public List<Shipment> getShipments();

	public List<Shipment> getShipments(Date beginningDate, Date endDate);

	public void acceptShipment(Shipment shipment, Date confirmantionDate);

	public Shipment getShipment(Waybill waybill);

	public List<Date> parseDateRangeValue(String dateRangeValue);

	public List<Shipment> getConfirmedShipments(String dateRangeValue,
			Provider provider);

	public void updateShipment(Shipment shipment);

	public List<ShipmentUnit> getShipmentUnitsByShipment(Shipment shipment);

	List<ShipmentUnitDto> convertShipmentUnitsToDto(
			List<ShipmentUnit> ShipmentUnits);

	public List<Shipment> getNotConfirmesShipments();

	List<Shipment> getConfirmedShipments(Provider provider);

}
