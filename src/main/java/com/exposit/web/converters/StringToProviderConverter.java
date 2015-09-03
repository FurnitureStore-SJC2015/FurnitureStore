package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.Provider;
import com.exposit.domain.service.UserService;

@Component
public class StringToProviderConverter implements Converter<String, Provider> {

	@Autowired
	private UserService userService;

	@Override
	public Provider convert(String providerId) {
		return (Provider) userService.getUserById(Integer.parseInt(providerId));
	}

}