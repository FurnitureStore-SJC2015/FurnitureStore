package com.exposit.service.dobrilko;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.service.dobrilko.PriceService;
import com.exposit.repository.dao.dobrilko.ShipmentDao;
import com.exposit.repository.dao.dobrilko.ShipmentUnitDao;
import com.exposit.repository.dao.dobrilko.WaybillDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.repository.dao.zanevsky.ProductCatalogUnitDao;

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

	@Transactional
	@Override
	public double calculateGain(Date beginningDate, Date endDate) {
		double gain = 0;

		for (Waybill waybill : waybillDao.getWaybills(beginningDate, endDate)) {
			Shipment shipment = shipmentDao.getShipment(waybill);
			for (ShipmentUnit shipmentUnit : shipmentUnitDao
					.getShipmentUnits(shipment)) {

				gain += shipmentUnit.getCost();

			}
			gain *= shipment.getProviderMarginPercent();
			gain += waybill.getDeliveryCost();

		}

		return gain;
	}

	@Transactional
	@Override
	public double calculateFullStorageModuleUnitPrice(
			StorageModuleUnit storageModuleUnit) {
		double baseCost = moduleDao.getModule(storageModuleUnit).getCost();
		double fullMargin = storageModuleUnit.getFullMargin();

		return baseCost + fullMargin;
	}

	//TODO
	/*
	@Transactional
	@Override
	public double calculateFullProductCatalogUnitPrice(
			
	}*/

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
