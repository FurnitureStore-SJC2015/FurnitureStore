package com.exposit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.domain.model.Waybill;
import com.exposit.domain.service.PriceService;
import com.exposit.domain.service.ShipmentService;
import com.exposit.domain.service.WaybillService;
import com.exposit.repository.dao.ModuleDao;
import com.exposit.repository.dao.ProductCatalogUnitDao;
import com.exposit.repository.dao.ShipmentDao;
import com.exposit.repository.dao.ShipmentUnitDao;
import com.exposit.repository.dao.WaybillDao;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private ShipmentDao shipmentDao;
	@Autowired
	private WaybillDao waybillDao;
	@Autowired
	private ShipmentUnitDao shipmentUnitDao;
	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private ProductCatalogUnitDao productCatalogUnitDao;

	@Autowired
	private WaybillService waybillService;
	@Autowired
	private ShipmentService shipmentService;

	@Transactional
	@Override
	public double calculateGain(List<Shipment> shipments) {
		double gain = 0;

		for (Shipment shipment : shipments) {
			double shipmentGain = 0;
			Waybill waybill = waybillService.getWaybillByShipment(shipment);
			for (ShipmentUnit shipmentUnit : shipmentService
					.getShipmentUnitsByShipment(shipment)) {
				shipmentGain += shipmentUnit.getCost();
			}
			shipmentGain *= shipment.getProviderMarginPercent() / 100;
			shipmentGain += waybill.getDeliveryCost();
			gain += shipmentGain;
		}

		return gain;
	}

	@Transactional
	@Override
	public double calculateGain(Shipment shipment) {

		double shipmentGain = 0;
		Waybill waybill = waybillService.getWaybillByShipment(shipment);
		for (ShipmentUnit shipmentUnit : shipmentService
				.getShipmentUnitsByShipment(shipment)) {
			shipmentGain += shipmentUnit.getCost();
		}
		shipmentGain *= shipment.getProviderMarginPercent() / 100;
		shipmentGain += waybill.getDeliveryCost();

		return shipmentGain;
	}

	@SuppressWarnings("deprecation")
	@Transactional
	@Override
	public List<Double> calculateYearGain(Provider provider) {
		shipmentService.getConfirmedShipments(provider);
		Double [] values = new Double[12];
		for (int i = 0; i < 12; i++) {
			values[i] = 0.0;
		}
		for(Shipment shipment: shipmentService.getConfirmedShipments(provider))
		{			
			values[waybillService.getWaybillByShipment(shipment).getConfirmationDate().getMonth()] += this.calculateGain(shipment);
		}

		return  Arrays.asList(values);
	}

	@Transactional
	@Override
	public double calculateFullStorageModuleUnitPrice(
			StorageModuleUnit storageModuleUnit) {
		double baseCost = moduleDao.getModule(storageModuleUnit).getCost();
		double fullMargin = storageModuleUnit.getFullMargin();

		return baseCost + fullMargin;
	}

	@Transactional
	@Override
	public double calculateStorageModuleUnitMargin(ShipmentUnit shipmentUnit) {

		double storageModuleUnitMargin = 0;
		Shipment shipment = shipmentDao.getShipment(shipmentUnit);
		int count = shipmentUnitDao.getShipmentUnits(shipment).size();
		double providerMarginPercent = shipment.getProviderMarginPercent();
		double basePrice = moduleDao.getModule(shipmentUnit).getCost();
		double deliveryCost = waybillDao.getWaybill(shipment).getDeliveryCost();
		storageModuleUnitMargin = providerMarginPercent * basePrice
				+ deliveryCost / count;

		return storageModuleUnitMargin;
	}

}
