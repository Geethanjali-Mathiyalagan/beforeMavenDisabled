package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class NameValidException extends Exception{
	static{
		Logger logger=LoggerFactory.getLogger(NameValidException.class);
		logger.info("Your name LENGTH should be more than 3 ALPHABETS!!") ;
	}
}

