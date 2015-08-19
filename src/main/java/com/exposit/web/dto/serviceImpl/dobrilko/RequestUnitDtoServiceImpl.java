package com.exposit.web.dto.serviceImpl.dobrilko;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.service.dobrilko.RequestService;
import com.exposit.web.dto.converters.dobrilko.RequestUnitDtoConverter;
import com.exposit.web.dto.dobrilko.RequestUnitDto;
import com.exposit.web.dto.service.dobrilko.RequestUnitDtoService;

@Service
public class RequestUnitDtoServiceImpl implements RequestUnitDtoService {

	@Autowired
	private RequestService requestService;
	@Autowired
	private RequestUnitDtoConverter requestUnitDtoConverter;

	@Override
	public List<RequestUnitDto> getAllRequestUnits() {
		List<RequestUnit> requestUnits = requestService.getAllRequestUnits();
		List<RequestUnitDto> requestUnitDtos = new ArrayList<RequestUnitDto>();
		for (RequestUnit requestUnit : requestUnits) {
			requestUnitDtos.add(this.requestUnitDtoConverter
					.convert(requestUnit));
		}
		return requestUnitDtos;

	}

	@Override
	public RequestUnitDto getById(int id) {
		RequestUnit requestUnit = requestService.getRequestUnitById(id);
		RequestUnitDto requestUnitDto = this.requestUnitDtoConverter
				.convert(requestUnit);
		return requestUnitDto;
	}

	@Override
	public List<RequestUnitDto> getRequestUnitsByRequest(Request request) {
		List<RequestUnit> requestUnits = requestService
				.getRequestUnitsByRequest(request);
		List<RequestUnitDto> requestUnitDtos = new ArrayList<RequestUnitDto>();
		for (RequestUnit requestUnit : requestUnits) {
			requestUnitDtos.add(this.requestUnitDtoConverter
					.convert(requestUnit));
		}
		return requestUnitDtos;

	}

}
