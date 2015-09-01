package com.exposit.domain.service.dobrilko;

import java.util.Date;
import java.util.List;

import com.exposit.domain.model.dobrilko.Provider;
import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.sorokin.Order;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.web.dto.dobrilko.RequestUnitDto;

public interface RequestService {

	public Integer saveRequest(Request request);

	public Request getRequestById(int id);

	public List<Request> getAllRequests();
	 
	public List<Request> getRequestByProvider(Provider provider);

	public void deleteRequest(int id);

	public Integer saveRequestUnit(RequestUnit requestUnit);

	public RequestUnit getRequestUnitById(int id);

	public List<RequestUnit> getAllRequestUnits();

	public void deleteRequestUnit(int id);

	public List<RequestUnit> getRequestUnitsByRequest(Request request);

	public Module getModuleByRequestUnit(RequestUnit requestUnit);

	public void processRequest(Request request, Date deliveryDate,
			int providerMarginPercent, double deliveryCost);
	
	public List<Request> createRequests(List<RequestUnitDto> requestUnits);
	
	public void sendRequest(Request request);
	

	public List<RequestUnitDto> convertRequestUnitsToDto(List<RequestUnit> requestUnits);
	
	public List<RequestUnitDto> convertOrderToRequestUnitsDto(Order order);

	public void updateRequest(Request request);

	public void sendRequests(Integer orderId);

	public List<RequestUnitDto> createRequestUnitDtos(Integer orderId);

	public void sendRequestFromRequestUnitDto(RequestUnitDto requestUnit);

	

}
