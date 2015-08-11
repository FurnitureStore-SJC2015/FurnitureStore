package com.exposit.service.dobrilko;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.domain.service.dobrilko.ReportService;
import com.exposit.repository.dao.dobrilko.ShipmentDao;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.dao.dobrilko.WaybillDao;

public class ReportServiceImpl implements ReportService {

	@Autowired
	private ShipmentDao shipmentDao;
	@Autowired
	private WaybillDao waybillDao;
	@Autowired
	private ShipmentUnitDao shipmentUnitDao;

	@Transactional
	@Override
	public double calculateGain(Date beginningDate, Date endDate) {
		double gain = 0;

		for (Waybill waybill : waybillDao.getWaybillsInPeriod(beginningDate,
				endDate)) {
			Shipment shipment = waybillDao.getShipmentByWaybill(waybill);
			for (ShipmentUnit shipmentUnit : shipmentDao
					.getShipmentUnitsByShipment(shipment)) {

				gain += shipmentUnit.getCost();

			}
			gain *= shipment.getProviderMarginPercent();
			gain += waybill.getDeliveryCost();

		}

		return gain;
	}

	@Transactional
	@Override
	public List<Waybill> showWaybillsFromPeriod(Date beginningDate, Date endDate) {
		return waybillDao.getWaybillsInPeriod(beginningDate, endDate);
	}

	@Transactional
	@Override
	public Shipment getShipmentByWaybill(Waybill waybill) {
		return waybillDao.getShipmentByWaybill(waybill);
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
	public List<Waybill> getWaybills() {
		return waybillDao.findAll();

	}
}
