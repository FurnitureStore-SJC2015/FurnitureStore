package com.exposit.domain.service.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.zanevsky.Module;

public interface RequestService {

	public Integer createRequest(Request request);

	public Request getRequestById(int id);

	public List<RequestUnit> getRequestUnitsByRequest(Request request);

	public Module getModuleByRequestUnit(RequestUnit requestUnit);

	public List<Request> showRequests();

	public Integer createRequestUnit(RequestUnit requestUnit);

}
