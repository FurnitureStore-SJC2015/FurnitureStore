package com.exposit.web.dto.service.dobrilko;

import java.util.List;

import com.exposit.domain.model.dobrilko.Request;
import com.exposit.web.dto.dobrilko.RequestUnitDto;

public interface RequestUnitDtoService {

	public List<RequestUnitDto> getAllRequestUnits();

	public RequestUnitDto getById(int id);
	
	public List<RequestUnitDto> getRequestUnitsByRequest(Request request);

}
