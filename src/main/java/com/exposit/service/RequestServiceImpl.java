package com.exposit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exposit.domain.model.Module;
import com.exposit.domain.model.Order;
import com.exposit.domain.model.ProductCatalogUnit;
import com.exposit.domain.model.ProductTemplate;
import com.exposit.domain.model.Provider;
import com.exposit.domain.model.Request;
import com.exposit.domain.model.RequestUnit;
import com.exposit.domain.model.Shipment;
import com.exposit.domain.model.ShipmentUnit;
import com.exposit.domain.model.Waybill;
import com.exposit.domain.service.ModuleService;
import com.exposit.domain.service.OrderService;
import com.exposit.domain.service.OrderUnitService;
import com.exposit.domain.service.ProductCatalogUnitService;
import com.exposit.domain.service.ProductTemplateService;
import com.exposit.domain.service.ProviderService;
import com.exposit.domain.service.RequestService;
import com.exposit.domain.service.ShipmentService;
import com.exposit.domain.service.WaybillService;
import com.exposit.repository.dao.ModuleDao;
import com.exposit.repository.dao.RequestDao;
import com.exposit.repository.dao.RequestUnitDao;
import com.exposit.web.dto.RequestUnitDto;

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

	@Override
	public Request getRequestById(int id) {
		return requestDao.findById(id);
	}

	
	@Override
	public List<RequestUnit> getRequestUnitsByRequest(Request request) {
		return requestUnitDao.getRequestUnits(request);
	}

	
	@Override
	public Module getModuleByRequestUnit(RequestUnit requestUnit) {
		return moduleDao.getModule(requestUnit);
	}

	@Transactional
	@Override
	public Integer saveRequest(Request request) {
		return requestDao.save(request);
	}

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


	@Override
	public RequestUnit getRequestUnitById(int id) {
		return requestUnitDao.findById(id);
	}

	
	@Override
	public List<RequestUnit> getAllRequestUnits() {

		return requestUnitDao.findAll();
	}

	@Transactional
	@Override
	public void updateRequest(Request request) {

		requestDao.update(request);
	}

	@Transactional
	@Override
	public void deleteRequestUnit(int id) {
		requestUnitDao.delete(id);

	}

	
	@Override
	public List<Request> getNotProcessedRequests(Provider provider){
		return requestDao.getNotProcessedRequests(provider);
	}
	
	@Transactional
	@Override
	public void processRequest(Request request, Date deliveryDate,
			int providerMarginPercent, double deliveryCost, Provider provider) {

		request.setProcessed(true);
		requestDao.update(request);
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
		shipment.setProvider(providerService.getProviderById(provider.getId()));
		shipmentService.updateShipment(shipment);

		waybill.setDeliveryCost(deliveryCost);
		waybill.setDeliveryDate(deliveryDate);
		waybill.setDepartureDate(new Date());
		waybill.setShipment(shipment);
		waybillService.updateWaybill(waybill);

	}

	
	@Override
	public List<Request> getRequestByProvider(Provider provider) {
		return requestDao.getRequests(provider);
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
			RequestUnitDto dto = new RequestUnitDto.Builder(module.getId(),
					requestUnit.getCount(), module.getModuleType().toString(),
					module.getCost(), providerNames, null).build();
			dtos.add(dto);
		}
		return dtos;

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
							.toString(), module.getId(), module.getCost(),
					providerNames).build();
			dtos.add(dto);
		}
		return dtos;
	}

	public Integer getNumberOfNotRequestedModuleUnits(Module module,
			Integer count) {

		Integer c = 0;
		for (RequestUnit requestUnit : requestUnitDao.getRequestUnits(module)) {
			c += requestUnit.getCount();
		}
		if (c < count) {
			return (count - c);
		} else {
			return 0;
		}
	}

	@Transactional
	@Override
	public List<RequestUnitDto> createRequestUnitDtos(Integer orderId) {
		HashMap<Module, Integer> modules = moduleService
				.getAbsentModulesInOrder(orderService.getOrderById(orderId));
		List<RequestUnitDto> requestUnitDtos = new ArrayList<RequestUnitDto>();
		for (Module module : modules.keySet()) {
			RequestUnitDto requestUnitDto = new RequestUnitDto();
			requestUnitDto.setModuleId(module.getId());
			requestUnitDto.setModuleCost(module.getCost());
			requestUnitDto.setModuleName(module.getModuleType().toString());
			requestUnitDto.setCount(this.getNumberOfNotRequestedModuleUnits(
					module, modules.get(module)));

			requestUnitDtos.add(requestUnitDto);

		}
		return requestUnitDtos;
	}

	@Transactional
	@Override
	public void sendRequests(Integer orderId) {
		HashMap<Module, Integer> modules = moduleService
				.getAbsentModulesInOrder(orderService.getOrderById(orderId));

		for (Module module : modules.keySet()) {
			if (!providerService.getProviders(module).isEmpty()) {
				Request request = new Request();
				request.setProvider(providerService.getProviders(module).get(0));
				request.setRequestDate(new Date());
				this.saveRequest(request);
				List<RequestUnit> requestUnits = new ArrayList<RequestUnit>();
				RequestUnit requestUnit = new RequestUnit();
				requestUnit.setCount(modules.get(module));
				requestUnit.setModule(module);
				requestUnit.setRequest(request);
				request.setRequestUnits(requestUnits);
				this.updateRequest(request);
			}
		}

	}

	@Transactional
	@Override
	public void sendRequestFromRequestUnitDto(RequestUnitDto requestUnit) {
		Request request = new Request();
		request.setProvider(providerService.getProviderById(Integer
				.parseInt(requestUnit.getChosenProvider())));
		request.setRequestDate(new Date());
		this.saveRequest(request);
		RequestUnit reqUnit = new RequestUnit(requestUnit.getCount(),
				moduleService.findById(requestUnit.getModuleId()));
		reqUnit.setRequest(request);
		this.saveRequestUnit(reqUnit);
		List<RequestUnit> requestUnits = new ArrayList<RequestUnit>();
		requestUnits.add(reqUnit);
		request.setRequestUnits(requestUnits);
		this.updateRequest(request);

	}
}