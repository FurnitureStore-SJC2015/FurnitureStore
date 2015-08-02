package com.exposit.repository.dao.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.repository.base.GenericDao;

public interface ShipmentDao extends GenericDao<Shipment, Integer> {

	public Waybill getWaybillByShipment(Shipment shipment);

	public Provider getProviderByShipment(Shipment shipment);

	public List<ShipmentUnit> getShipmentUnitsByShipment(Shipment shipment);
}
