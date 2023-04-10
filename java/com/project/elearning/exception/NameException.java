package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class NameException extends Exception {

	 static{
		 Logger logger=LoggerFactory.getLogger(NameException.class);
		 logger.info("Your name should contain  only ALPHABETS ! ");
	}

}
