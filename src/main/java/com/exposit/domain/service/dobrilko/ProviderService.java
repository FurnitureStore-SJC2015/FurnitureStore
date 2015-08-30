package com.exposit.domain.service.dobrilko;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.zanevsky.Module;

public interface ProviderService {

	public Integer saveProvider(Provider provider);

	public void deleteProvider(Integer id);

	public List<Provider> getProviders();

	public Provider getProviderById(Integer id);

	public void updateProvider(Provider provider);

	public Provider getProvider(Request request);

	public Provider getProvider(Shipment shipment);

	public List<Provider> getProviders(Module module);

	public void setChangedFields(Provider loggedProvider,
			Provider editedProvider, MultipartFile avatar);

	public Provider getProviderByName(String providerName);

}
