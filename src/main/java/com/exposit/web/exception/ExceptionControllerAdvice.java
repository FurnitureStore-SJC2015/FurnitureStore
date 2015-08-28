package com.exposit.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.exceptions.SuchUserRegisteredException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public ModelAndView defaultErrorHandler(Exception e) {
		ModelAndView mav = new ModelAndView("generic-error");
		mav.addObject("name", e.getClass().toString());
		mav.addObject("message", e.getMessage());
		return mav;
	}

	@ExceptionHandler(SuchUserRegisteredException.class)
	public ModelAndView suchUserRegisteredExceptionHandler(
			SuchUserRegisteredException ex) {
		ModelAndView mav = new ModelAndView("generic-error");
		mav.addObject("name", "Such User Registered!");
		mav.addObject("message", ex.getMessage());
		return mav;
	}

}
