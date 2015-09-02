package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Request;
import com.exposit.domain.model.Shipment;
import com.exposit.repository.base.GenericDao;

public interface ProviderDao extends GenericDao<Provider, Integer> {

	public Provider getProvider(Request request);

	public Provider getProvider(Shipment shipment);

	public List<Provider> getProviders(Module module);

	public Provider getProviderByName(String name);

}
