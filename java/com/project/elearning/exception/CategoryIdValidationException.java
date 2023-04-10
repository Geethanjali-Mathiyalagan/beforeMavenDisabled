package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class CategoryIdValidationException extends Exception{
	static{
		Logger logger=LoggerFactory.getLogger(CategoryIdValidationException.class);
		logger.info("-----------------Oops..!Enter selected category..........Correctly..........");
	}
}
