package com.exposit.repository.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.Waybill;
import com.exposit.repository.base.GenericDao;

public interface ShipmentDao extends GenericDao<Shipment, Integer> {

	public Shipment getShipment(ShipmentUnit shipmentUnit) ;

	public List<Shipment> getShipments(Provider provider) ;

	public Shipment getShipment(Waybill waybill) ;

	public List<Shipment> getConfirmedShipments(Date beginningDate,
			Date endDate, Provider provider);

	public List<Shipment> getNotConfirmedShipments();

	public List<Shipment> getConfirmedShipments(Provider provider);

}
