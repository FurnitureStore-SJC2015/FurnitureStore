package com.exposit.service.dobrilko;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.repository.dao.dobrilko.WaybillDao;

@Service
public class WaybillServiceImpl implements WaybillService {

	@Autowired
	private WaybillDao waybillDao;

	@Transactional
	@Override
	public List<Waybill> getWaybills() {
		return waybillDao.findAll();
	}

	@Transactional
	@Override
	public Integer saveWaybill(Waybill waybill) {
		return waybillDao.save(waybill);
	}

	@Transactional
	@Override
	public void deleteWaybill(int id) {
		waybillDao.delete(id);

	}

	@Transactional
	@Override
	public Waybill getWaybillById(int id) {
		return waybillDao.findById(id);
	}

	@Transactional
	@Override
	public Waybill getWaybillByShipment(Shipment shipment) {
		return waybillDao.getWaybill(shipment);
	}

	@Transactional
	@Override
	public List<Waybill> getWaybills(Date beginningDate, Date endDate) {
		return waybillDao.getWaybills(beginningDate, endDate);
	}

	@Transactional
	@Override
	public void setConfirmationDate(Date confirmationDate, Waybill waybill) {
		waybill.setConfirmationDate(confirmationDate);
		waybillDao.update(waybill);

	}

	@Override
	public void updateWaybill(Waybill waybill) {
		waybillDao.update(waybill);

	}
}
