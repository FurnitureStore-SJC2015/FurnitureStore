package com.exposit.service.dobrilko;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestUnitDao requestUnitDao;
	@Autowired
	private RequestDao requestDao;

	@Transactional
	@Override
	public Integer createRequestUnit(RequestUnit requestUnit) {
		return requestUnitDao.save(requestUnit);
	}

	@Transactional
	@Override
	public Request getRequestById(int id) {
		return requestDao.findById(id);
	}

	@Transactional
	@Override
	public List<RequestUnit> getRequestUnitsByRequest(Request request) {
		return requestDao.getRequestUnitsByRequest(request);
	}

	@Transactional
	@Override
	public List<Request> showRequests() {
		return requestDao.findAll();
	}

	@Transactional
	@Override
	public Module getModuleByRequestUnit(RequestUnit requestUnit) {
		return requestUnitDao.getModuleByRequestUnit(requestUnit);
	}

	@Override
	public Integer createRequest(Request request) {
		return requestDao.save(request);
	}

}
