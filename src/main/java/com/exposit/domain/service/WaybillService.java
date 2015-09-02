package com.exposit.domain.service;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.Waybill;

public interface WaybillService {

	public List<Waybill> getWaybills();

	public Integer saveWaybill(Waybill waybill);

	public void deleteWaybill(int id);

	public Waybill getWaybillById(int id);

	public void setConfirmationDate(Date confirmationDate, Waybill waybill);

	public List<Waybill> getWaybills(Date beginningDate, Date endDate);

	public void updateWaybill(Waybill waybill);

	public Waybill getWaybillByShipment(Shipment shipment);

}
