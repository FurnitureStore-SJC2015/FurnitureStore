package com.exposit.domain.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomException extends Exception {

	private static final long serialVersionUID = -4744430183523721711L;

	private String message = "This is an exception..";

	public CustomException(String message) {

		this.message = message;

	}

	public String getMessage() {

		return message;

	}

	public void setMessage(String message) {

		this.message = message;

	}

}
