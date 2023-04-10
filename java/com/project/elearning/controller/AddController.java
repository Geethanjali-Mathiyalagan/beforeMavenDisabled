package com.project.elearning.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.elearning.dao.AdminCourseDao;
import com.project.elearning.dao.AdminInstructorDao;
import com.project.elearning.dao.InstructorDao;
import com.project.elearning.dao.LearnerDao;
import com.project.elearning.exception.InvalidPasswordException;
import com.project.elearning.exception.MailIdException;
import com.project.elearning.exception.NameException;
import com.project.elearning.exception.NameValidException;
import com.project.elearning.exception.PasswordInvalidException;
import com.project.elearning.exception.UPIValidException;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.AdminInstructor;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.CourseSelect;
import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Learner;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Test;
import com.project.elearning.service.AdminCourseService;
import com.project.elearning.service.InstructorService;
import com.project.elearning.service.LearnerService;
import com.project.elearning.validation.ValidationCheck;

@Controller
public class AddController {
	LearnerDao learnerDao= new LearnerDao();
	InstructorDao dao = new InstructorDao();
	InstructorService service = new InstructorService();
	AdminCourseService services = new AdminCourseService();
	LearnerService learnerService = new LearnerService();

AdminInstructorDao adminInstructorDao=new AdminInstructorDao();
AdminCourseDao adminCourseDao = new AdminCourseDao();
	
ValidationCheck valid = new ValidationCheck();

HttpSession session;
	
	@PostMapping("/removeQuestions")
	public String removeQuestions(@RequestParam("questionNo")Integer questionNo) {
		Test test=new Test();	
		test.setQuestionNo(questionNo);
		service.questionsRemove(test);
		return "Instructor";
		
	}
	@GetMapping("/updateGrade")
	public String updateMarks(@ModelAttribute("marks")Mark mark,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession session) {
		httpServletRequest.getParameter("LearnerId");
		session.setAttribute("LearnerCode",httpServletRequest.getParameter("LearnerId"));
		return "LearnerDetail";
	}
	
	@PostMapping("/updateDetail")
	public String updateLearners(@ModelAttribute("marks")Mark mark) {
		
		service.learnersUpdate(mark);
		return "InstructorDashboard";
	}
	
	@PostMapping("/removeCourses")
	public String removeCourse(@ModelAttribute("course")AdminCourse course) {
		
	services.courseRemove(course);
		return "AdminDashboard";
	}
	
	@RequestMapping("/addMcq")
	public ModelAndView addQuestions(@ModelAttribute("Question")Test test,@ModelAttribute("InstructorLogin")Instructors instruct, Model model,HttpSession session) {
		Integer instructorId=(Integer) session.getAttribute("Instruct");
		ModelAndView modelAndView = new ModelAndView("AddQuestions");
	    modelAndView.addObject("message", instructorId);
	    List<String>list=dao.dynamicCourseName();
		  model.addAttribute("dynamic",list);
	   
	    return modelAndView;
		
	}
	
	
	@PostMapping("/addQuestions")
	public String insertQuestion(@ModelAttribute("Question")Test test,Instructors instruct, Model model) {
      
      
		services.questionInsert(test);
		return "InstructorDashboard";
		
	}
	
	@RequestMapping("/apply")
	public String addPayment(@ModelAttribute("Payment")CourseEnroll course,HttpSession session,Model model,HttpServletRequest httpServletRequest) {

httpServletRequest.getParameter("InstructorId");
session.setAttribute("InstrcutorCode",httpServletRequest.getParameter("InstructorId"));
		learnerDao.getAmount( session, model);
		learnerDao.getCourseNameDynamic(session,model);
		return "Payments";
	}
	@RequestMapping("/insertCourses")
	public String addCourseDetail(@ModelAttribute("AddCourse")CourseSelect courseSelect,Model model) {
		adminCourseDao.dynamicCategoryCode(model);
		return "AddCourse";
	}
	@PostMapping("/insertionOfCourse")
	public String addCourses(@ModelAttribute("AddCourse")CourseSelect courseSelect) {
		
		services.addCourses(courseSelect);
		return "Admin";
	}
	@GetMapping("/listOfCourseDetail")
	public String courseList(Model model) {
		
		adminCourseDao.listOfCourseDetails(model);
		return "ListOfCourses";
	}
	@GetMapping("/myLearn")
	public String learnings(HttpSession session,Model model) {
		learnerDao.getLearnerDetails(session, model);
		return "Profile";
	}
	@RequestMapping("/About")
	public String aboutUs() {
		return "About";
	}
	@RequestMapping("/Contact")
	public String contactUs() {
		return "Contact";
	}
	@RequestMapping("/paided")
	public String paid() {
		return "PaymentForm";
	}

	@RequestMapping("/Registration")
	public String insertLearnerDetail(@ModelAttribute("user")Learner learn,Model model,HttpSession session)  
	{
		for (int i = 1; i <=9; i++) {
            session.removeAttribute("errorMessage1" + i);
        }
		if(Boolean.FALSE.equals(valid.nameValidation(learn.getLearnerName(), model))
		 ||Boolean.FALSE.equals(valid.validatingName(learn.getLearnerName(), model))
	     ||Boolean.FALSE.equals(valid.passwordValid(learn.getLearnerPassword(), model))
         ||Boolean.FALSE.equals(valid.validatingPassword(learn.getLearnerPassword(), model))
         ||Boolean.FALSE.equals(valid.mailValidation(learn.getLearnerMailId(), model))
         ||Boolean.FALSE.equals(learnerDao.checkMail(learn, model)))
         {
             
             for (int j = 1; j <=9; j++) {
            	 
                 if (model.getAttribute("errorMessage" + j) != null) 
                 {

                     String errorMessage = (String) model.getAttribute("errorMessage" + j);
                     model.addAttribute("ErrorMessage", errorMessage);
                     return "ErrorPopup";
                 }
                 else {
                 learnerService.addLearnerDetails(learn, session);
                 List<AdminCourse> course=adminCourseDao.listOfCourses(model);
                 model.addAttribute("courseDetail", course);
                 return "RegisterPopup";
                 }
             }
         
		}
		return "ErrorPopup";		

	}
	
	@RequestMapping("/registerPopup")
	public String returnCourseList(Model model) {
		 List<AdminCourse> course=adminCourseDao.listOfCourses(model);
         model.addAttribute("courseDetail", course);
         
         return "CourseList";
	}
}
 	
