package com.exposit.service.dobrilko;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.dobrilko.Shipment;
import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.dobrilko.Waybill;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.domain.model.zanevsky.OrderUnit;
import com.exposit.domain.model.zanevsky.ProductCatalogUnit;
import com.exposit.domain.model.zanevsky.ProductTemplate;
import com.exposit.domain.service.dobrilko.ProviderService;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.domain.service.dobrilko.ShipmentService;
import com.exposit.domain.service.dobrilko.WaybillService;
import com.exposit.domain.service.sorokin.OrderService;
import com.exposit.domain.service.zanevsky.ModuleService;
import com.exposit.domain.service.zanevsky.OrderUnitService;
import com.exposit.domain.service.zanevsky.ProductCatalogUnitService;
import com.exposit.domain.service.zanevsky.ProductTemplateService;
import com.exposit.repository.dao.dobrilko.RequestDao;
import com.exposit.repository.dao.dobrilko.RequestUnitDao;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.web.dto.dobrilko.RequestUnitDto;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestUnitDao requestUnitDao;
	@Autowired
	private RequestDao requestDao;
	@Autowired
	private ModuleDao moduleDao;

	@Autowired
	private WaybillService waybillService;
	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private ProviderService providerService;

	@Autowired
	private ProductTemplateService productTemplateService;

	@Autowired
	private ProductCatalogUnitService productCatalogUnitService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderUnitService orderUnitService;

	@Transactional
	@Override
	public Request getRequestById(int id) {
		return requestDao.findById(id);
	}

	@Transactional
	@Override
	public List<RequestUnit> getRequestUnitsByRequest(Request request) {
		return requestUnitDao.getRequestUnits(request);
	}

	@Transactional
	@Override
	public Module getModuleByRequestUnit(RequestUnit requestUnit) {
		return moduleDao.getModule(requestUnit);
	}

	@Override
	public Integer saveRequest(Request request) {
		return requestDao.save(request);
	}

	@Transactional
	@Override
	public List<Request> getAllRequests() {
		return requestDao.findAll();

	}

	@Transactional
	@Override
	public void deleteRequest(int id) {
		requestDao.delete(id);
	}

	@Transactional
	@Override
	public Integer saveRequestUnit(RequestUnit requestUnit) {

		return requestUnitDao.save(requestUnit);
	}

	@Transactional
	@Override
	public RequestUnit getRequestUnitById(int id) {
		return requestUnitDao.findById(id);
	}

	@Transactional
	@Override
	public List<RequestUnit> getAllRequestUnits() {

		return requestUnitDao.findAll();
	}

	@Transactional
	@Override
	public void deleteRequestUnit(int id) {
		requestUnitDao.delete(id);

	}

	@Transactional
	@Override
	public void processRequest(Request request, Date deliveryDate,
			int providerMarginPercent, double deliveryCost) {

		Shipment shipment = new Shipment();
		Waybill waybill = new Waybill();
		waybillService.saveWaybill(waybill);
		shipmentService.saveShipment(shipment);
		List<ShipmentUnit> shipmentUnits = new ArrayList<ShipmentUnit>();
		List<RequestUnit> requestUnits = this.getRequestUnitsByRequest(request);
		for (RequestUnit requestUnit : requestUnits) {
			ShipmentUnit shipmentUnit = new ShipmentUnit();
			shipmentUnit.setCount(requestUnit.getCount());
			shipmentUnit.setModule(this.getModuleByRequestUnit(requestUnit));
			shipmentUnit.setCost(this.getModuleByRequestUnit(requestUnit)
					.getCost());
			shipmentUnit.setShipment(shipment);
			shipmentUnits.add(shipmentUnit);
			shipmentService.saveShipmentUnit(shipmentUnit);
		}

		shipment.setShipmentUnits(shipmentUnits);
		shipment.setProviderMarginPercent(providerMarginPercent);
		shipment.setProcessed(true);
		shipment.setWaybill(waybill);

		shipmentService.updateShipment(shipment);

		waybill.setDeliveryCost(deliveryCost);
		waybill.setDeliveryDate(deliveryDate);
		waybill.setDepartureDate(new Date());
		waybill.setShipment(shipment);
		waybillService.updateWaybill(waybill);

	}

	@Transactional
	@Override
	public List<Request> getRequestByProvider(Provider provider) {
		return requestDao.getRequests(provider);
	}

	@Override
	public List<Request> createRequests(List<RequestUnitDto> requestUnits) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestUnitDto> convertRequestUnitsToDto(
			List<RequestUnit> requestUnits) {
		List<RequestUnitDto> dtos = new ArrayList<RequestUnitDto>();
		for (RequestUnit requestUnit : requestUnits) {
			Module module = moduleService.getModule(requestUnit);
			List<Provider> providers = providerService.getProviders(module);
			List<String> providerNames = new ArrayList<String>();
			for (Provider provider : providers) {
				providerNames.add(provider.getName());
			}
			RequestUnitDto dto = new RequestUnitDto.Builder(
					requestUnit.getId(), requestUnit.getCount(), module
							.getModuleType().toString(), module.getCost(),
					providerNames).build();
			dtos.add(dto);
		}
		return dtos;

	}

	@Override
	public void sendRequests(List<Request> requests) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void sendRequest(Request request) {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public List<RequestUnitDto> convertOrderToRequestUnitsDto(Order order) {
		List<RequestUnitDto> dtos = new ArrayList<RequestUnitDto>();
		List<ProductCatalogUnit> productCatalogUnits = productCatalogUnitService
				.getProducts(order);
		List<ProductTemplate> productTemplates = new ArrayList<ProductTemplate>();
		for (ProductCatalogUnit productCatalogUnit : productCatalogUnits) {
			for (ProductTemplate productTemplate : productTemplateService
					.getProductTemplates(productCatalogUnit)) {
				productTemplates.add(productTemplate);
			}
		}
		for (ProductTemplate productTemplate : productTemplates) {
			Module module = moduleService.getModule(productTemplate);
			List<Provider> providers = providerService.getProviders(module);
			List<String> providerNames = new ArrayList<String>();
			for (Provider provider : providers) {
				providerNames.add(provider.getName());
			}
			RequestUnitDto dto = new RequestUnitDto.Builder(
					productTemplate.getCount(), module.getModuleType()
							.toString(), module.getCost(), providerNames)
					.build();
			dtos.add(dto);
		}
		return dtos;
	}
	
	
	
}
