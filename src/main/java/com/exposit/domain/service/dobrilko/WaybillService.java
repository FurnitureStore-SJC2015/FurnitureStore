package com.exposit.domain.service.dobrilko;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.Waybill;

public interface WaybillService {

	public List<Waybill> getWaybills();

	public Integer saveWaybill(Waybill waybill);

	public void deleteWaybill(int id);

	public Waybill getWaybillById(int id);

	public void setConfirmationDate(Date confirmationDate, Waybill waybill);

	public List<Waybill> getWaybills(Date beginningDate, Date endDate);

	public List<Waybill> getConfirmedWaybills(Date beginningDate, Date endDate);

	public List<Waybill> getConfirmedWaybills();

	public void updateWaybill(Waybill waybill);

	public Waybill getWaybillByShipment(Shipment shipment);

}
