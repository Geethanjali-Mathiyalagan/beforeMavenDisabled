package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class CourseValidationException extends Exception {
	
	static{
		Logger logger=LoggerFactory.getLogger(CourseValidationException.class);
		logger.info(".................Oops....!....Enter Selectd course Correctly................");
	}
}
