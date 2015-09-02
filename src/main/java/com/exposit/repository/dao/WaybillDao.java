package com.exposit.repository.dao;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.Waybill;
import com.exposit.repository.base.GenericDao;

public interface WaybillDao extends GenericDao<Waybill, Integer> {

	public Waybill getWaybill(Shipment shipment);

	public List<Waybill> getWaybills(Date beginningDate, Date endDate);

	public List<Waybill> getConfirmedWaybills(Date beginningDate, Date endDate);

	public List<Waybill> getConfirmedWaybills(Date beginningDate, Date endDate,
			Provider provider);

	public List<Waybill> getConfirmedWaybills();
}
