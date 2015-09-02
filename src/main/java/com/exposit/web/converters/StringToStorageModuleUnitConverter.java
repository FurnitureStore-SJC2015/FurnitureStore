package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.StorageModuleUnit;
import com.exposit.domain.service.StorageModuleUnitService;

@Component
public class StringToStorageModuleUnitConverter implements
		Converter<String, StorageModuleUnit> {

	@Autowired
	private StorageModuleUnitService storageModuleUnitService;

	@Override
	public StorageModuleUnit convert(String unitId) {
		return storageModuleUnitService.getStorageModuleUnitById(Integer
				.parseInt(unitId));
	}

}
