package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.repository.base.GenericDao;

public interface ShipmentUnitDao extends GenericDao<ShipmentUnit, Integer> {

	public List<ShipmentUnit> getShipmentUnits(Shipment shipment);
}
