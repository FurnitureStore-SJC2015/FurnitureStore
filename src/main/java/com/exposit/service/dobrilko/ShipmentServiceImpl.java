package com.exposit.service.dobrilko;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;
import com.exposit.repository.dao.dobrilko.ShipmentDao;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.dao.dobrilko.StorageModuleUnitDao;
import com.exposit.repository.dao.dobrilko.WaybillDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	// TODO ask if you can use instance of other service
	@Autowired
	private PriceService priceService;
	@Autowired
	private WaybillService waybillService;
	@Autowired
	private StorageModuleUnitDao storageModuleUnitDao;
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
	@Autowired
	private ModuleDao moduleDao;

	@Transactional
	@Override
	public Integer saveShipment(Shipment shipment) {
		return shipmentDao.save(shipment);
	}

	@Transactional
	@Override
	public Shipment getShipment(Waybill waybill) {
		return shipmentDao.getShipment(waybill);
	}

	@Transactional
	@Override
	public Shipment getShipmentById(int id) {
		return shipmentDao.findById(id);
	}

	@Transactional
	@Override
	public List<Shipment> getShipments() {
		return shipmentDao.findAll();
	}

	@Transactional
	@Override
	public List<Shipment> getShipments(Date beginningDate, Date endDate) {
		List<Shipment> shipments = new ArrayList<Shipment>();
		for (Waybill waybill : waybillDao.getWaybills(beginningDate, endDate)) {

			shipments.add(shipmentDao.getShipment(waybill));
		}
		return shipments;
	}

	@Transactional
	@Override
	public void acceptShipment(Shipment shipment, Date confirmationDate) {

		waybillService.setConfirmationDate(confirmationDate,
				waybillDao.getWaybill(shipment));

		List<ShipmentUnit> shipmentUnits = shipmentUnitDao
				.getShipmentUnits(shipment);
		StorageModuleUnit smu = new StorageModuleUnit();

		for (ShipmentUnit shipmentUnit : shipmentUnits) {

			double fullSmuMargin = priceService
					.calculateStorageModuleUnitMargin(shipmentUnit);
			smu = storageModuleUnitDao.getStorageModuleUnit(moduleDao
					.getModule(shipmentUnit));
			if (smu != null) {
				smu.setCount(smu.getCount() + shipmentUnit.getCount());
				smu.setFullMargin(fullSmuMargin);
				storageModuleUnitDao.update(smu);
			} else {
				smu = new StorageModuleUnit();
				smu.setCount(shipmentUnit.getCount());
				smu.setFullMargin(fullSmuMargin);
				smu.setModule(moduleDao.getModule(shipmentUnit));
				storageModuleUnitDao.save(smu);
			}

		}
	}

	@Transactional
	@Override
	public Shipment getShipmentByWaybill(Waybill waybill) {
		return shipmentDao.getShipment(waybill);
	}

}
