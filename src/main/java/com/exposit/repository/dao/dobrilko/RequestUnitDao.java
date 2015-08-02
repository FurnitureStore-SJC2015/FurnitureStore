package com.exposit.repository.dao.dobrilko;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.base.GenericDao;

public interface RequestUnitDao extends GenericDao<RequestUnit, Integer> {

	public Request getRequestByRequestUnit(RequestUnit requestUnit);

	public Module getModuleByRequesiUnit(RequestUnit requestUnit);
}
