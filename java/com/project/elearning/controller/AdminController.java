package com.project.elearning.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.dao.AdminCourseDao;
import com.project.elearning.dao.AdminDao;
import com.project.elearning.dao.AdminInstructorDao;
import com.project.elearning.dao.InstructorDao;
import com.project.elearning.dao.LearnerDao;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.Admin;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.Feedback;
import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Instructor;
import com.project.elearning.pojo.Learner;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Test;
import com.project.elearning.service.AdminCourseService;
import com.project.elearning.validation.ValidationCheck;

@Controller
public class AdminController {

AdminCourseService service = new AdminCourseService();

AdminDao adminDao = new AdminDao();

ValidationCheck valid = new ValidationCheck();

Logger logger=LoggerFactory.getLogger(AdminController.class);

@RequestMapping("/adminLoginCredential")
public String register(@ModelAttribute("admin") Admin admin) {
	
	
	 return "Admin";
		
}

@RequestMapping("/adminLogin")
public String loginAdmin(@ModelAttribute("admin") Admin admin,HttpSession session,Model model) {
	
	if(Boolean.TRUE.equals(service.adminLogin(admin, session))) {
		
		  service.learnerCount(model);
		  service.coursesCount(model);
		  service.incomeCount(model);
		  service.instructorCount(model);
			
	      service.maximumCourseCount(model);
	      service.maximumChoosedCourse(model);
	      service.minimumCourseCount(model);
	      service.minimumChoosedCourse(model);
			 
			 
		return "AdminDashboard";

	}
	else if(Boolean.FALSE.equals(service.adminLogin(admin, session))) {
	 return "index"; 
	 }
	 
	else {
	
	return "Home";
	
	}
}
	
	
@GetMapping("/courseList")
public String getAllCategories(Model model) {

	service.getCategories(model);
	
    return "CourseList";

}

@GetMapping("/courseNamesList")
public String getListOfCategories(Model model) {
	service.getCategories(model);
	return "ListOfCategories";
}

@RequestMapping("/instructorList")
public String getInstructorList(Model model) throws JsonProcessingException {
	service.getInstructors(model);
	return "InstructorsList";
}

@RequestMapping("/removeLearner")
public String register(@ModelAttribute("remove")Learner learn) {
	
	
	 return "RemoveLearners";
		
}


@PostMapping("/removeLearners")
public String remove(@ModelAttribute("remove")Learner learn) {
	
	logger.info("RemoveController");
	
	service.removeLearners(learn);
	return "AdminDashboard";
}

@GetMapping("/paymentList")
public String getPaymentList(Model model) {
	service.paymentList(model);
	return "PaymentList";
}

@GetMapping("/Learners")
public String getLearnerList(Model model) {
	service.learnerList(model);
	return "LearnerResultList";
}

@GetMapping("/getPercentage")
public String getPercentages(Model model,HttpSession session) {
	service.takePercentage(model,session);
	Float checkPercentage=(Float) session.getAttribute("percentage");

	for (int i = 1; i <=9; i++) {
        session.removeAttribute("errorMessage1" + i);
    }
	
	if(Boolean.FALSE.equals(valid.validationOfPercentage(checkPercentage,model)))
		 {
             
             for (int j = 1; j <=9; j++) {
                 if (model.getAttribute("errorMessage" + j) != null) 
                 {
                     String errorMessage = (String) model.getAttribute("errorMessage" + j);
                     model.addAttribute("ErrorMessage", errorMessage);
                     return "CertificateError";
                 }
                 else {
                	 
                	 return "Certificate";
                 }
             }
         }	

	return "CertificateError";
}

@GetMapping("/home")
public String rerurnHomePage() {
	return "Home";
}


@RequestMapping("/addCourses")
public String addCourse(@ModelAttribute("course")AdminCourse course) {
	return "AddCategories";
}

@PostMapping("/insertCourse")
public String insertCourses(@RequestParam("image")MultipartFile image,@RequestParam("categeoryId")Integer categeoryId,@RequestParam("categoryName")String categoryName,@RequestParam("descriptions")String descriptions,@RequestParam("amount")Integer amount) throws IOException {
	AdminCourse course = new AdminCourse();
	
	String fileName=image.getOriginalFilename();
   try( FileInputStream file=new FileInputStream("C:\\Users\\geet3334\\eclipse-workspace\\OnlineLearning\\src\\main\\resources\\static\\image\\"+fileName);){
	   byte[] images=file.readAllBytes();
	   course.setImage(images);
	   
   }
    course.setCategeoryId(categeoryId);
    course.setCategoryName(categoryName);
    course.setDescriptions(descriptions);
    course.setAmount(amount);
	service.addCourseDetails(course);
	return "CourseList";
}

@RequestMapping("/updateCourses")
public String courseUpdate(@ModelAttribute("update")AdminCourse course) {
	return "UpdateCourse";
}

@PostMapping("/updateCourse")
public String updateCourse(@ModelAttribute("update")AdminCourse course) {
	
	
    service.courseUpdate(course);
	return "index";
}
@RequestMapping("/deleteCourse")
public String deleteCourse(@ModelAttribute("course")AdminCourse course) {
	return "RemoveCourse";
}






@PostMapping("/updateQuestions")
public String updateQuestions(@RequestParam("question")String question,@RequestParam("option1")String option1,@RequestParam("option2")String option2,@RequestParam("option3")String option3,@RequestParam("correctAnswer")String correctAnswer,@RequestParam("questionNo")Integer questionNo) {
	Test test=new Test();	
	test.setQuestion(question);
	test.setOption1(option1);
	test.setOption2(option2);
	test.setOption3(option3);
	test.setCorrectAnswer(correctAnswer);
	test.setQuestionNo(questionNo);
	service.questionsUpdate(test);
	return "Instructor";
}


}

