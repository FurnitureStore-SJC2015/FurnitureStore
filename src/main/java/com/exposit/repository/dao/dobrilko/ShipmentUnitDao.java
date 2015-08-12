package com.exposit.repository.dao.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.repository.base.GenericDao;

public interface ShipmentUnitDao extends GenericDao<ShipmentUnit, Integer> {

	public List<ShipmentUnit> getShipmentUnits(Shipment shipment);
}
