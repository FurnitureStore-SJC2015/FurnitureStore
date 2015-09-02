package com.exposit.repository.dao;

import java.util.List;

import com.exposit.domain.model.OrderUnit;
import com.exposit.domain.model.Status;
import com.exposit.repository.base.GenericDao;

public interface StatusDao extends GenericDao<Status, Integer>{
	
	public Status getStatus(OrderUnit orderUnit);
}
