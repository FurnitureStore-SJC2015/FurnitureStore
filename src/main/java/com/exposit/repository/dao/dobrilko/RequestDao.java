package com.exposit.repository.dao.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.repository.base.GenericDao;

public interface RequestDao extends GenericDao<Request, Integer> {

	public Provider getProviderByRequest(Request request);

	public List<RequestUnit> getRequestUnitsByRequest(Request request);
}
