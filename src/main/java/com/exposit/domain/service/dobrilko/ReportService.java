package com.exposit.domain.service.dobrilko;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.Waybill;

public interface ReportService {
	
	public double calculateGain(Date beginningDate, Date endDate);

	public List<Waybill> showWaybillsFromPeriod(Date beginningDate, Date endDate);

	public Shipment getShipmentByWaybill(Waybill waybill);

	public Shipment getShipmentById(int id);

	public List<Shipment> getShipments();

	public List<Waybill> getWaybills();
	

}
