package com.exposit.service.dobrilko;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.domain.service.zanevsky.ModuleService;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.dao.dobrilko.ShipmentDao;
import com.exposit.repository.dao.dobrilko.StorageModuleUnitDao;
import com.exposit.repository.dao.dobrilko.WaybillDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.web.dto.dobrilko.ShipmentUnitDto;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private PriceService priceService;
	@Autowired
	private WaybillService waybillService;
	@Autowired
	private StorageModuleUnitDao storageModuleUnitDao;
	@Autowired
	private ShipmentUnitDao ShipmentUnitDao;
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
	@Autowired
	private ModuleService moduleService;

	@Transactional
	@Override
	public Integer saveShipment(Shipment shipment) {
		return shipmentDao.save(shipment);
	}

	@Transactional
	@Override
	public List<Shipment> getNotConfirmesShipments() {
		return shipmentDao.getNotConfirmedShipments();
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

	@Transactional
	@Override
	public List<ShipmentUnit> getShipmentUnitsByShipment(Shipment shipment) {
		return shipmentUnitDao.getShipmentUnits(shipment);
	}

	@SuppressWarnings("deprecation")
	@Transactional
	@Override
	public List<Date> parseDateRangeValue(String dateRangeValue) {
		List<Date> dates = new ArrayList<Date>();
		dateRangeValue.trim();
		String[] dateStrings = dateRangeValue.split("-");
		for (String dateString : dateStrings) {
			dateString.trim();
			String[] dateValues = dateString.split("/");
			Integer months = Integer.parseInt(dateValues[0].trim());
			Integer days = Integer.parseInt(dateValues[1].trim());
			Integer year = Integer.parseInt(dateValues[2].trim());
			dates.add(new Date(year - 1900, months - 1, days));
		}
		return dates;
	}

	@Transactional
	@Override
	public Integer saveShipmentUnit(ShipmentUnit shipmentUnit) {
		return shipmentUnitDao.save(shipmentUnit);
	}

	@Transactional
	@Override
	public void updateShipment(Shipment shipment) {
		shipmentDao.update(shipment);

	}

	@Override
	public List<Shipment> getConfirmedShipments(String dateRangeValue,
			Provider provider) {
		List<Date> dates = this.parseDateRangeValue(dateRangeValue);

		return shipmentDao.getConfirmedShipments(dates.get(0), dates.get(1),
				provider);
	}

	@Override
	public List<Shipment> getConfirmedShipments(Provider provider) {
		return shipmentDao.getConfirmedShipments(provider);
	}

	@Override
	public List<ShipmentUnitDto> convertShipmentUnitsToDto(
			List<ShipmentUnit> ShipmentUnits) {
		List<ShipmentUnitDto> dtos = new ArrayList<ShipmentUnitDto>();
		for (ShipmentUnit shipmentUnit : ShipmentUnits) {
			Module module = moduleService.getModule(shipmentUnit);

			ShipmentUnitDto dto = new ShipmentUnitDto.Builder(
					shipmentUnit.getId(), shipmentUnit.getCount(), module
							.getModuleType().toString(), module.getCost(),
					shipmentUnit.getCost()).build();

			dtos.add(dto);
		}
		return dtos;

	}
}
