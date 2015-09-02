package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Request;
import com.exposit.domain.model.RequestUnit;
import com.exposit.repository.base.GenericDao;

public interface RequestDao extends GenericDao<Request, Integer> {

	public Request getRequest(RequestUnit requestUnit);

	public List<Request> getRequests(Provider provider);

	public List<Request> getNotProcessedRequests(Provider provider);
}
