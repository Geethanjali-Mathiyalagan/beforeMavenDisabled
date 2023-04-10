package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class PasswordInvalidException extends Exception {

static{
	Logger logger=LoggerFactory.getLogger(PasswordInvalidException.class);
	logger.info("PASSWORD must include one LOWERCASE  and UPPERCASE");
}
}
