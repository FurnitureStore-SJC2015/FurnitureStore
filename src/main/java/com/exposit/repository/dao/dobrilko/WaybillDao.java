package com.exposit.repository.dao.dobrilko;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.repository.base.GenericDao;

public interface WaybillDao extends GenericDao<Waybill, Integer> {

	public Shipment getShipmentByWaybill(Waybill waybill);
}
