package com.project.elearning.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.elearning.controller.AdminController;

public class PaytmValidException extends Exception{

	static{
		Logger logger=LoggerFactory.getLogger(PaytmValidException.class);
		logger.info("Your Entered Paytm Number is Not Valid Try again.....!");
	}
}
