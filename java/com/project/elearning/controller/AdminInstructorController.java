package com.project.elearning.controller;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.project.elearning.dao.AdminCourseDao;
import com.project.elearning.dao.AdminInstructorDao;
import com.project.elearning.dao.LearnerDao;
import com.project.elearning.exception.UPIValidException;
import com.project.elearning.pojo.AdminInstructor;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.service.AdminInstructorService;
import com.project.elearning.service.LearnerService;
import com.project.elearning.validation.ValidationCheck;

@Controller
public class AdminInstructorController {
	
	AdminInstructorDao adminInstructorDao = new AdminInstructorDao();

	AdminCourseDao adminCourseDao = new AdminCourseDao();
	
	AdminInstructorService service= new AdminInstructorService();
	
	LearnerDao learnerDao=new LearnerDao();
	
	ValidationCheck valid=new ValidationCheck();
	
	LearnerService learnerService=new LearnerService();
	
	Logger logger=LoggerFactory.getLogger(AdminInstructorController.class);
	
	@RequestMapping("/addInstructors")
	public String addInstructors(@ModelAttribute("AddInstructors")AdminInstructor admininstruct) {
	
		return "AddInstructors";
	}
	

	@RequestMapping("/insertInstructorDetails")
	public String insertInstructorDetail(@ModelAttribute("AddInstructors")AdminInstructor admininstruct) {
		logger.info("InstructorDetails");
		
		
		service.addInstructors(admininstruct);
		
		return "Home";
	}
	
	@RequestMapping("/removeInstrutors")
	public String deleteIntructor(@ModelAttribute("Remove")AdminInstructor adminInstruct) {
		
		return "RemoveInstructor";
	}
	
	
	@GetMapping("/deleteInstructor")
	public String removeInstructors(@ModelAttribute("Remove")AdminInstructor adminInstruct) {
		
		adminInstructorDao.deleteInstrcutorDetails(adminInstruct);
		return "Home";
	}
	

	@RequestMapping("/updateInstructors")
	public String updateInstructors(@ModelAttribute("update")AdminInstructor admininstruct)
	{
		return "UpdateInstructor";
	}
	
	
@PostMapping("/updateInstructor")
public String updateInstructorDetails(@ModelAttribute("update")AdminInstructor admininstruct) {
	logger.info("Update Instructors");
	
	
	adminInstructorDao.updateInstructorDetails(admininstruct);

	return "Home";
}


@GetMapping("/courseEnrolls")
public String courseEnrolls(@ModelAttribute("Payment")CourseEnroll course,HttpSession session,Model model) throws UPIValidException {


	for (int i = 1; i <=9; i++) {
        session.removeAttribute("errorMessage1" + i);
    }
	
	if(Boolean.FALSE.equals( valid.gPayValidation(course.getPaymentDetail(), model)))
		 {
             
             for (int j = 1; j <=9; j++) {
                 if (model.getAttribute("errorMessage" + j) != null) {
                     String errorMessage = (String) model.getAttribute("errorMessage" + j);
                     model.addAttribute("ErrorMessage", errorMessage);
                 }
             }
             return "ErrorPopup";
         }	
	 
	course.setPaymentType("Gpay");

	
	

	Integer id = learnerDao.givePaymentId();
	course.setPaymnetId(id);
	course.setPaymnetId(id);
	
	course.setPaymentStatus("paided");

	learnerService.courseEnrolling(course, session);
	learnerService.takeScriptVideo(model, session);
	return "EnrollVideo";

}

@GetMapping("/courseEnroll")
public String courseEnroll(@ModelAttribute("Payment")CourseEnroll course, HttpSession session,Model model)  {
	
	for (int i = 1; i <=9; i++) {
        session.removeAttribute("errorMessage1" + i);
    }
	
	if(Boolean.FALSE.equals(valid.cardValidation(course.getPaymentDetail(), model))) 
		 {
             
             for (int j = 1; j <=9; j++) {
                 if (model.getAttribute("errorMessage" + j) != null) {
                     String errorMessage = (String) model.getAttribute("errorMessage" + j);
                     model.addAttribute("ErrorMessage", errorMessage);
                 }
             }
             return "ErrorPopup";
         }		
		
	session.setAttribute("course", course.getCourseName());
	course.setCategoryId(course.getCategoryId());
	
	course.setPaymentType("Credit Card");

	
	

	Integer id = learnerDao.givePaymentId();
	course.setPaymnetId(id);
	course.setPaymnetId(id);
	
	course.setPaymentStatus("paided");

	learnerService.enrollCourse(course, session);
	learnerService.takeScriptVideo(model, session);
	return "EnrollVideo";

}

}
		


