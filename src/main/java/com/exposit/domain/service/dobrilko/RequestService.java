package com.exposit.domain.service.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.zanevsky.Module;

public interface RequestService {

	public Integer saveRequest(Request request);

	public Request getRequestById(int id);

	public List<Request> getAllRequests();

	public void deleteRequest(int id);

	public Integer saveRequestUnit(RequestUnit requestUnit);

	public RequestUnit getRequestUnitById(int id);

	public List<RequestUnit> getAllRequestUnits();

	public void deleteRequestUnit(int id);

	public List<RequestUnit> getRequestUnitsByRequest(Request request);

	public Module getModuleByRequestUnit(RequestUnit requestUnit);

}
