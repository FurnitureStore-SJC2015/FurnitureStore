package com.exposit.repository.dao.zanevsky;

import java.util.List;

import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.Status;
import com.exposit.repository.base.GenericDao;

public interface StatusDao extends GenericDao<Status, Integer>{
	
	public Status getStatus(OrderUnit orderUnit);
}
