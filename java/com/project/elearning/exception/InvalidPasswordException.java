package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class InvalidPasswordException extends Exception {
	static{
		Logger logger=LoggerFactory.getLogger(InvalidPasswordException.class);
		logger.info("Oops..........Your Paswword length must be 10  !");
	}
}
