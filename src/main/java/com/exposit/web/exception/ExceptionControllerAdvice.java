package com.exposit.web.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.exceptions.SuchUserRegisteredException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	/*
	 * @ExceptionHandler(value = { Exception.class, RuntimeException.class })
	 * public ModelAndView defaultErrorHandler(Exception e) { Logger logger =
	 * Logger.getLogger(ExceptionControllerAdvice.class);
	 * logger.error(e.getMessage(), e); ModelAndView mav = new
	 * ModelAndView("generic-error"); mav.addObject("name",
	 * e.getClass().toString()); mav.addObject("message", e.getMessage());
	 * return mav; }
	 */

	@ExceptionHandler(SuchUserRegisteredException.class)
	public ModelAndView suchUserRegisteredExceptionHandler(
			SuchUserRegisteredException ex) {
		Logger logger = Logger.getLogger(ExceptionControllerAdvice.class);
		logger.error(ex.getMessage(), ex);
		ModelAndView mav = new ModelAndView("generic-error");
		mav.addObject("name", "Such User Registered!");
		mav.addObject("message", ex.getMessage());
		return mav;
	}
}
