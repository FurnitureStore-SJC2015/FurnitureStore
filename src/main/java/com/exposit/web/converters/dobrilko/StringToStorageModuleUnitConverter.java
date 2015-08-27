package com.exposit.web.converters.dobrilko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.dobrilko.StorageModuleUnit;
import com.exposit.domain.service.dobrilko.StorageModuleUnitService;

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
