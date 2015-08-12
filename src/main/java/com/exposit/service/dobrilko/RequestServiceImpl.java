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
import com.exposit.repository.dao.zanevsky.ModuleDao;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestUnitDao requestUnitDao;
	@Autowired
	private RequestDao requestDao;
	@Autowired
	private ModuleDao moduleDao;

	@Transactional
	@Override
	public Request getRequestById(int id) {
		return requestDao.findById(id);
	}

	@Transactional
	@Override
	public List<RequestUnit> getRequestUnitsByRequest(Request request) {
		return requestUnitDao.getRequestUnits(request);
	}

	@Transactional
	@Override
	public Module getModuleByRequestUnit(RequestUnit requestUnit) {
		return moduleDao.getModule(requestUnit);
	}

	@Override
	public Integer saveRequest(Request request) {
		return requestDao.save(request);
	}

	@Transactional
	@Override
	public List<Request> getAllRequests() {
		return requestDao.findAll();

	}

	@Transactional
	@Override
	public void deleteRequest(int id) {
		requestDao.delete(id);
	}

	@Transactional
	@Override
	public Integer saveRequestUnit(RequestUnit requestUnit) {

		return requestUnitDao.save(requestUnit);
	}

	@Transactional
	@Override
	public RequestUnit getRequestUnitById(int id) {
		return requestUnitDao.findById(id);
	}

	@Transactional
	@Override
	public List<RequestUnit> getAllRequestUnits() {

		return requestUnitDao.findAll();
	}

	@Transactional
	@Override
	public void deleteRequestUnit(int id) {
		requestUnitDao.delete(id);

	}

}
