package com.exposit.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.exposit.domain.model.User;
import com.exposit.domain.service.UserService;

@Component
public class StringToUserConverter implements Converter<String, User> {

	@Autowired
	private UserService userService;

	@Override
	public User convert(String id) {
		return userService.getUserById(Integer.parseInt(id));
	}
}
