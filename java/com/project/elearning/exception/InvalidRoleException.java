package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class InvalidRoleException extends Exception{
	static{
		Logger logger=LoggerFactory.getLogger(InvalidRoleException.class);
	logger.info(" SORRY....Invalid access!  You are a Learner Please choose Learner  go to next Step !!");
	}
}
