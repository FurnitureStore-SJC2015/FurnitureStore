package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.Request;
import com.exposit.domain.service.RequestService;

@Component
public class StringToRequestConverter implements Converter<String, Request> {

	@Autowired
	private RequestService requestService;

	@Override
	public Request convert(String requestId) {
		return requestService.getRequestById(Integer.parseInt(requestId));
	}
}
