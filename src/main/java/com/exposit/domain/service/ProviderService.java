package com.exposit.domain.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Request;
import com.exposit.domain.model.Shipment;

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
