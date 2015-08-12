package com.exposit.repository.dao.dobrilko;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.repository.base.GenericDao;

public interface ProviderDao extends GenericDao<Provider, Integer> {

	public Provider getProvider(Request request);

	public Provider getProvider(Shipment shipment);

}
