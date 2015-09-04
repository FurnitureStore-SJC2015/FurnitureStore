package com.exposit.web.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.exposit.domain.exceptions.DuplicateUserAccountException;

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

	@ExceptionHandler(DuplicateUserAccountException.class)
	public ModelAndView suchUserRegisteredExceptionHandler(
			DuplicateUserAccountException ex) {
		Logger logger = Logger.getLogger(ExceptionControllerAdvice.class);
		logger.error(ex.getMessage(), ex);
		ModelAndView mav = new ModelAndView("generic-error");
		mav.addObject("name", "Duplicate User Account!");
		mav.addObject("message", ex.getMessage());
		return mav;
	}

	@ExceptionHandler(value = { NullPointerException.class,
			IllegalArgumentException.class })
	public ModelAndView nullPointerExceptionHandle(Exception ex) {
		Logger logger = Logger.getLogger(Exception.class);
		logger.error(ex.getMessage(), ex);
		ModelAndView mav = new ModelAndView("generic-error");
		mav.addObject("name", "Not found on this site!");
		mav.addObject("message", "Check your request!");
		return mav;
	}
}
