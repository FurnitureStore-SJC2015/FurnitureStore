package com.exposit.service.dobrilko;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.service.dobrilko.ProviderService;
import com.exposit.domain.service.zanevsky.ModuleService;
import com.exposit.repository.dao.dobrilko.ProviderDao;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private ProviderDao providerDao;
	@Autowired
	private ModuleService moduleService;

	@Transactional
	@Override
	public Integer saveProvider(Provider provider) {
		return providerDao.save(provider);
	}

	@Transactional
	@Override
	public void deleteProvider(Integer id) {
		providerDao.delete(id);

	}

	@Override
	public Provider getProviderByName(String providerName) {
		return providerDao.getProviderByName(providerName);
	}

	@Transactional
	@Override
	public List<Provider> getProviders() {
		return providerDao.findAll();
	}

	@Transactional
	@Override
	public Provider getProviderById(Integer id) {
		return providerDao.findById(id);
	}

	@Transactional
	@Override
	public void updateProvider(Provider provider) {
		providerDao.update(provider);
	}

	@Transactional
	@Override
	public Provider getProvider(Request request) {
		return providerDao.getProvider(request);
	}

	@Transactional
	@Override
	public Provider getProvider(Shipment shipment) {
		return providerDao.getProvider(shipment);
	}

	@Override
	public List<Provider> getProviders(Module module) {
		return providerDao.getProviders(module);
	}

	@Override
	public void setChangedFields(Provider loggedProvider,
			Provider editedProvider, MultipartFile avatar) {
		loggedProvider.setEmail(editedProvider.getEmail());
		loggedProvider.setProviderName(editedProvider.getProviderName());
		loggedProvider
				.setPassword(encoder.encode(editedProvider.getPassword()));
		loggedProvider.setPhone(editedProvider.getPhone());
		loggedProvider.setZipCode(editedProvider.getZipCode());
		if (avatar != null) {
			try {
				loggedProvider.setAvatar(avatar.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
