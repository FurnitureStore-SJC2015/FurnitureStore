package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.Role;
import com.exposit.domain.model.RoleType;
import com.exposit.domain.service.RoleService;

@Component
public class StringToRoleConverter implements Converter<String, Role> {

	@Autowired
	private RoleService roleSevice;

	@Override
	public Role convert(String id) {
		return roleSevice.getRoleById(Integer.valueOf(id));

	}

}
