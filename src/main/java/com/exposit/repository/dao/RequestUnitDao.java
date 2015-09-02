package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Request;
import com.exposit.domain.model.RequestUnit;
import com.exposit.repository.base.GenericDao;

public interface RequestUnitDao extends GenericDao<RequestUnit, Integer> {

	public List<RequestUnit> getRequestUnits(Request request);

	public List<RequestUnit> getRequestUnits(Module module);
}
