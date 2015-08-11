package com.exposit.service.dobrilko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;
import com.exposit.repository.dao.dobrilko.ShipmentDao;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.dao.dobrilko.WaybillDao;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private RequestUnitDao requestUnitDao;
	@Autowired
	private ShipmentUnitDao shipmentUnitDao;
	@Autowired
	private ShipmentDao shipmentDao;
	@Autowired
	private WaybillDao waybillDao;
	@Autowired
	private RequestDao requestDao;

	@Transactional
	@Override
	public Integer createShipment(Request request, Shipment shipment) {
		for (RequestUnit requestUnit : requestDao
				.getRequestUnitsByRequest(request)) {
			ShipmentUnit shipmentUnit = new ShipmentUnit();

			shipmentUnit.setCost(requestUnitDao.getModuleByRequestUnit(
					requestUnit).getCost());
			shipmentUnit.setCount(requestUnit.getCount());
			shipmentUnit.setShipment(shipment);
			shipmentUnitDao.save(shipmentUnit);
		}

		return shipmentDao.save(shipment);

	}

	@Transactional
	@Override
	public Integer createWaybill(Waybill waybill) {
		return waybillDao.save(waybill);

	}

}
