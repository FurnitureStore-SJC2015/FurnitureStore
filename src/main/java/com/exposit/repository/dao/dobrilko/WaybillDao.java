package com.exposit.repository.dao.dobrilko;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.repository.base.GenericDao;

public interface WaybillDao extends GenericDao<Waybill, Integer> {

	public Shipment getShipmentByWaybill(Waybill waybill);
	
	public List<Waybill> getWaybillsInPeriod(Date beginningDate, Date endDate);
}
