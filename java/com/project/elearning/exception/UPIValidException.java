package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class UPIValidException extends Exception {
	
	private static final long serialVersionUID = 1L;

	static{
		Logger logger=LoggerFactory.getLogger(UPIValidException.class);
		logger.info("Your Gpay Number is not Valid");
	}
}
