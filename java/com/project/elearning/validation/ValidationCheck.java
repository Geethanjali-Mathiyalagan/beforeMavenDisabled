package com.project.elearning.validation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.ui.Model;

import com.project.elearning.exception.CategoryIdValidationException;
import com.project.elearning.exception.CourseValidationException;
import com.project.elearning.exception.UPIValidException;
import com.project.elearning.exception.IdValidationException;
import com.project.elearning.exception.InvalidPasswordException;
import com.project.elearning.exception.InvalidRoleException;
import com.project.elearning.exception.MailIdException;
import com.project.elearning.exception.NameException;
import com.project.elearning.exception.NameValidException;
import com.project.elearning.exception.PasswordInvalidException;
import com.project.elearning.exception.PaytmValidException;


public class ValidationCheck {
	
	public  boolean nameValidation(String name,Model model) {
		
		String regex="[a-z.A-Z]+";	
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(name);
		Boolean valid=m.matches();
		if(Boolean.TRUE.equals(valid)) {
		return true;
		}
		else 
		{
			String errorMessage="Name must be in Alphabates";
			model.addAttribute("errorMessage1", errorMessage);
			return false;
		}
		
	}
	public  boolean mailValidation(String mailId,Model model)   {
		final String EMAIL_PATTERN="^[a-zA-Z0-9+.-]+@[a-zA-Z+.-]+$";
		Pattern obj=Pattern.compile(EMAIL_PATTERN);
		Matcher matcher=obj.matcher(mailId);
		boolean match=matcher.matches();
		if(Boolean.TRUE.equals(match)) {
		return true;
		}else
		{
			String errorMessage="Please follow the given Pattern your maill id should be Recommanded as mindspace@gmail.com !";
		    model.addAttribute("errorMessage2", errorMessage);
		    return false;
		}
		

	}
	
	public  boolean validatingPassword(String password,Model model) {
		Boolean wname=password.matches(".*[a-z].*")&&password.matches(".*[A-Z].*");//password must include one lower case and upper case
		if(Boolean.TRUE.equals(wname))	{	
		return true;
		
		}
		else
		{
		String errorMessage="Password must include one lower case and upper case";
		model.addAttribute("errorMessage3", errorMessage);
		return false;
		}
}
	
	public  boolean validatingName(String name,Model model) {
		if(name != null && !name.trim().isEmpty() && name.length()>=3) {
		return true;
	}
		else {
			
			String errorMessage="Name should not be Empty";
			model.addAttribute("errorMessage4", errorMessage);
			return false;
			
		}
}
	public  boolean passwordValid(String password,Model model){
		if(password.length()<10) {
			return true;
		}
		else
		{
			String errorMessage="Password length must be with in 10 digits";
			model.addAttribute("errorMessage5", errorMessage);
			return false;
		}
	}
		public boolean gPayValidation(long gpay,Model model){
	        String regex="\\d{10}"; 
	          String gpay1=Long.toString(gpay);
	          Pattern pattern=Pattern.compile(regex);
	            Matcher match=pattern.matcher(gpay1);
	            Boolean b=match.matches();
	            if(Boolean.TRUE.equals(b)) {
	                return true;
	}
	            else {
	            	String errorMessage="Your Gpay number is invalid";
	            	model.addAttribute("errorMessage6", errorMessage);
	            	return false;
	            }
	            
		}
	            public boolean cardValidation(long card,Model model) {
	            	String regex="\\d{16}"; 
	            	String gpay=Long.toString(card);
	            	Pattern pattern=Pattern.compile(regex);
	            	Matcher match=pattern.matcher(gpay);
	            	Boolean b=match.matches();
	            	if(Boolean.TRUE.equals(b)) {
	            		return true;
	            	}
	            	else {
	            		String errorMessage="Please Enter valid Card Number";
	            		model.addAttribute("errorMessage7", errorMessage);
	            		return false;
	            	}
	
}
	            public boolean validationOfPercentage(Float percentage,Model model) {
	            	if(percentage<=50) {
	            		return true;
	            	}
	            	else {
	            		String errorMessage="Not enough Mark to generate certficate so Take RETEST";
	            		model.addAttribute("errorMessage9",errorMessage);
	            		return false;
	            	}
	            }
	           

}