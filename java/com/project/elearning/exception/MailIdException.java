package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class MailIdException extends Exception {
	static{
		
		Logger logger=LoggerFactory.getLogger(MailIdException.class);
logger.info("Please follow the given Pattern your maill id should be Recommanded as learnfinity12@gmail.com ! ");
	}
}
