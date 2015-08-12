package com.exposit.domain.service.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;

public interface ProviderService {

	public Integer saveProvider(Provider provider);

	public void deleteProvider(Integer id);

	public List<Provider> getProviders();

	public Provider getProviderById(Integer id);

	public void updateProvider(Provider provider);

	public Provider getProvider(Request request);

	public Provider getProvider(Shipment shipment);
}
