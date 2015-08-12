package com.exposit.service.dobrilko;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.service.dobrilko.ProviderService;
import com.exposit.repository.dao.dobrilko.ProviderDao;

public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderDao providerDao;

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

}
