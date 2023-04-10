package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class IdValidationException extends Exception{
	static{
		Logger logger=LoggerFactory.getLogger(IdValidationException.class);
		logger.info("------------------INVALID CREDENTIALS-------------------------");
	}
}
