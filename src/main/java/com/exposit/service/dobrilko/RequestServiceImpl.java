package com.exposit.service.dobrilko;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestUnitDao requestUnitDao;
	@Autowired
	private RequestDao requestDao;
	@Autowired
	private ModuleDao moduleDao;

	@Autowired
	private WaybillService waybillService;
	@Autowired
	private ShipmentService shipmentService;

	@Transactional
	@Override
	public Request getRequestById(int id) {
		return requestDao.findById(id);
	}

	@Transactional
	@Override
	public List<RequestUnit> getRequestUnitsByRequest(Request request) {
		return requestUnitDao.getRequestUnits(request);
	}

	@Transactional
	@Override
	public Module getModuleByRequestUnit(RequestUnit requestUnit) {
		return moduleDao.getModule(requestUnit);
	}

	@Override
	public Integer saveRequest(Request request) {
		return requestDao.save(request);
	}

	@Transactional
	@Override
	public List<Request> getAllRequests() {
		return requestDao.findAll();

	}

	@Transactional
	@Override
	public void deleteRequest(int id) {
		requestDao.delete(id);
	}

	@Transactional
	@Override
	public Integer saveRequestUnit(RequestUnit requestUnit) {

		return requestUnitDao.save(requestUnit);
	}

	@Transactional
	@Override
	public RequestUnit getRequestUnitById(int id) {
		return requestUnitDao.findById(id);
	}

	@Transactional
	@Override
	public List<RequestUnit> getAllRequestUnits() {

		return requestUnitDao.findAll();
	}

	@Transactional
	@Override
	public void deleteRequestUnit(int id) {
		requestUnitDao.delete(id);

	}

	@Override
	public void processRequest(Request request, Date deliveryDate,
			int providerMarginPercent, double deliveryCost) {

		Shipment shipment = new Shipment();
		Waybill waybill = new Waybill();
		waybillService.saveWaybill(waybill);
		shipmentService.saveShipment(shipment);
		List<ShipmentUnit> shipmentUnits = new ArrayList<ShipmentUnit>();
		List<RequestUnit> requestUnits = this.getRequestUnitsByRequest(request);
		for (RequestUnit requestUnit : requestUnits) {
			ShipmentUnit shipmentUnit = new ShipmentUnit();
			shipmentUnit.setCount(requestUnit.getCount());
			shipmentUnit.setModule(this.getModuleByRequestUnit(requestUnit));
			shipmentUnit.setCost(this.getModuleByRequestUnit(requestUnit)
					.getCost());
			shipmentUnit.setShipment(shipment);
			shipmentUnits.add(shipmentUnit);
			shipmentService.saveShipmentUnit(shipmentUnit);
		}

		shipment.setShipmentUnits(shipmentUnits);
		shipment.setProviderMarginPercent(providerMarginPercent);
		shipment.setProcessed(true);
		shipment.setWaybill(waybill);

		shipmentService.updateShipment(shipment);

		waybill.setDeliveryCost(deliveryCost);
		waybill.setDeliveryDate(deliveryDate);
		waybill.setDepartureDate(new Date());
		waybill.setShipment(shipment);
		waybillService.updateWaybill(waybill);

	}
}
