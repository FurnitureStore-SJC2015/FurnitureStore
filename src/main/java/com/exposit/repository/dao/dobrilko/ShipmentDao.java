package com.exposit.repository.dao.dobrilko;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.repository.base.GenericDao;

public interface ShipmentDao extends GenericDao<Shipment, Integer> {

	public Shipment getShipment(ShipmentUnit shipmentUnit) ;

	public List<Shipment> getShipments(Provider provider) ;

	public Shipment getShipment(Waybill waybill) ;

	public List<Shipment> getConfirmedShipments(Date beginningDate,
			Date endDate, Provider provider);

	public List<Shipment> getNotConfirmedShipments();

}
