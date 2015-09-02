package com.exposit.domain.service;

import java.util.List;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.StorageModuleUnit;

public interface PriceService {

	public double calculateStorageModuleUnitMargin(ShipmentUnit shipmentUnit);

	double calculateFullStorageModuleUnitPrice(
			StorageModuleUnit storageModuleUnit);

	public double calculateGain(List<Shipment> shipments);

	public List<Double> calculateYearGain(Provider provider);

	public double calculateGain(Shipment shipment);



}
