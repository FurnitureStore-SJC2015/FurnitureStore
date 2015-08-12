package com.exposit.repository.dao.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.repository.base.GenericDao;

public interface RequestUnitDao extends GenericDao<RequestUnit, Integer> {

	public List<RequestUnit> getRequestUnits(Request request);
}
