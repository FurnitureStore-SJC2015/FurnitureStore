package com.exposit.repository.dao.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.repository.base.GenericDao;

public interface ProviderDao extends GenericDao<Provider, Integer> {

	public List<Request> getRequestsByProvider(Provider provider);

	public List<Shipment> getShipmentsByProvider(Provider provider);

}
