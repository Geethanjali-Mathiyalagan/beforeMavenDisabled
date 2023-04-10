package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class EmailIdException extends Exception {
	static{
		Logger logger=LoggerFactory.getLogger(EmailIdException.class);
		logger.info("Already Exist");
		
	}
}
