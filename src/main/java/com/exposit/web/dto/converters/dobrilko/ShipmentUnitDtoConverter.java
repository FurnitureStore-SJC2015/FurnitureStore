package com.exposit.web.dto.converters.dobrilko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.dobrilko.ShipmentUnit;
import com.exposit.domain.model.zanevsky.Module;
import com.exposit.repository.dao.zanevsky.ModuleDao;
import com.exposit.web.dto.dobrilko.ShipmentUnitDto;

@Component
public class ShipmentUnitDtoConverter {
	@Autowired
	private ModuleDao moduleDao;

	public ShipmentUnitDto convert(ShipmentUnit shipmentUnit) {

		Module module = moduleDao.getModule(shipmentUnit);
		ShipmentUnitDto shipmentUnitDto = new ShipmentUnitDto();
		shipmentUnitDto.setCount(shipmentUnit.getCount());
		shipmentUnitDto.setId(shipmentUnit.getId());
		shipmentUnitDto.setModuleName(module.getModuleType().toString());
		shipmentUnitDto.setModuleCost(module.getCost());
		return shipmentUnitDto;

	}
}
