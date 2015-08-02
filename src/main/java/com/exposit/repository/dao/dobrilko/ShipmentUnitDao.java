package com.exposit.repository.dao.dobrilko;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.base.GenericDao;

public interface ShipmentUnitDao extends GenericDao<ShipmentUnit, Integer> {

	public Module getModuleByShipmentUnit(ShipmentUnit shipmentUnit);

	public Shipment getShipmentByShipmentUnit(ShipmentUnit shipmentUnit);
}
