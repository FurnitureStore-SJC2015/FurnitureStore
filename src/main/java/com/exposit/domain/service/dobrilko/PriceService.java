package com.exposit.domain.service.dobrilko;

import java.util.Date;

import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.StorageModuleUnit;

public interface PriceService {

	public double calculateGain(Date beginningDate, Date endDate);

	public double calculateStorageModuleUnitMargin(ShipmentUnit shipmentUnit);

	double calculateFullStorageModuleUnitPrice(
			StorageModuleUnit storageModuleUnit);

	// TODO
	/*
	 * double calculateFullProductCatalogUnitPrice( ProductCatalogUnit
	 * productCatalogUnit, double companyMargin);
	 */

}
