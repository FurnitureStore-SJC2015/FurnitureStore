package com.exposit.web.dto.converters.dobrilko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.dobrilko.RequestUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.web.dto.dobrilko.RequestUnitDto;

@Component
public class RequestUnitDtoConverter {
	@Autowired
	private ModuleDao moduleDao;

	public RequestUnitDto convert(RequestUnit requestUnit) {

		Module module = moduleDao.getModule(requestUnit);
		RequestUnitDto requestUnitDto = new RequestUnitDto();
		requestUnitDto.setCount(requestUnit.getCount());
		requestUnitDto.setId(requestUnit.getId());
		requestUnitDto.setModuleName(module.getModuleType().toString());
		requestUnitDto.setModuleCost(module.getCost());
		return requestUnitDto;

	}

}
