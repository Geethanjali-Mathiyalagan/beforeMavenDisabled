package com.project.elearning.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.dao.AdminCourseDao;
import com.project.elearning.dao.AdminInstructorDao;
import com.project.elearning.dao.LearnerDao;
import com.project.elearning.exception.EmailIdException;
import com.project.elearning.exception.UPIValidException;
import com.project.elearning.exception.InvalidPasswordException;
import com.project.elearning.exception.MailIdException;
import com.project.elearning.exception.NameException;
import com.project.elearning.exception.NameValidException;
import com.project.elearning.exception.PasswordInvalidException;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.CourseSelect;
import com.project.elearning.pojo.Feedback;
import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Instructor;
import com.project.elearning.pojo.Learner;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Test;
import com.project.elearning.pojo.Video;
import com.project.elearning.service.InstructorService;
import com.project.elearning.service.LearnerService;
import com.project.elearning.validation.ValidationCheck;

@Controller
public class LearnerController {
	InstructorService instructorService =new InstructorService();
	
	LearnerService service = new LearnerService();
	
	LearnerDao learnerDao = new LearnerDao();
	
	AdminCourseDao  admincourseDao = new AdminCourseDao();
	
	HttpSession session;
	
	ValidationCheck valid = new ValidationCheck();

	Logger logger=LoggerFactory.getLogger(LearnerController.class);
	
	@RequestMapping("/")
	public String learner() {
	
		
		 return "Home";
			
	}
	@GetMapping("/Register")
	public String register(@ModelAttribute("user")Learner learn) {
		
		
		 return "Registered";
			
	}
	

	
	@RequestMapping("/learnerLogin")
	public String loginLearner(@ModelAttribute("user")Learner learn,HttpSession session, Model model) {
		
		
		if(Boolean.TRUE.equals(learnerDao.learnerLogin(learn, session))) {
			List<AdminCourse> course=admincourseDao.listOfCourses(model);
			 model.addAttribute("courseDetail", course);
			return "CourseList";
		}
		else if(Boolean.FALSE.equals(learnerDao.learnerLogin(learn, session))) {
			
			return "ErrorPopup";
		}
		else {
			return "index";
		}
}

	@PostMapping("/submit")
	public String getMarks(@RequestParam("count")Integer score,@RequestParam("learnerId")Integer learnerId,@RequestParam("instructorId")Integer instructorId) {
		Mark mark = new Mark();
		Integer score1=score;
		Float percentage=(float) (score1*10);
		mark.setLearnerId(learnerId);
		mark.setInstructorId(instructorId);
		
		mark.setScore(score1);
		mark.setPercentage(percentage);
		service.scoreInsert(mark);
		return "TestPopup";
	}
	
	@GetMapping("/UserList")
	public String getUserList(Model model) {
	service.listUesr(model);
		return "LearnersList";
	}

	@PostMapping("/SelectedList")

	public String getSelectedList( @RequestParam("categeoryId") Integer categeoryId,Model model, CourseSelect course,HttpSession session,Instructors instruct) {
      
		Integer id=course.getCategoryId();
       
		course.setCategoryId(id);
		service.listCourse(categeoryId, model, session);		
		return "SelectCourse";
	}

	@PostMapping("/CourseDetail")
	public String getCourseDetail(@RequestParam("checkBox") Integer categoriesId, Model model,
			Instructors instruct,HttpSession session) throws JsonProcessingException {
		
		instruct.setCategoriesId(categoriesId);
		service.deatailOfCourse(model, instruct);
		
		
		return "CourseDetail";
	}


@PostMapping("/feedback")
public String ratings(@ModelAttribute("Feedback")Feedback feed) {

	service.giveRatings(feed);
	return "Home";
}

@GetMapping("/getFeedback")
public String getFeedbackList(Model model) {
	service.feedbackList(model);
	return "Feedback";
}

@PostMapping("/UpdatePassword")
public String updateLearners(@RequestParam("password")String password,@RequestParam("learnerId")int learnerId) {
	Learner learn=new Learner();
	learn.setLearnerId(learnerId);
	learn.setLearnerPassword(password);
	learnerDao.updateLearner(learn);
	return "Registered";
}
@GetMapping("/searchQuery")
public String searchCourse(@RequestParam("search")String courseName,Model model) {
	CourseSelect pojo= new CourseSelect();
	pojo.setCourseName(courseName);
	List<CourseSelect> courses=learnerDao.searchCourseName(pojo);
	model.addAttribute("SearchCourse", courses);
	if(courses.isEmpty()) {
		return "Popup";
	}
	return "SelectedCourse";
	}

@GetMapping("/testQuestion")
public String test(HttpSession session,Model model) {
	learnerDao.testQuestions(session, model);
	learnerDao.testMcqQuestions(session, model);
	return "Test";
}
@RequestMapping("/submitted")
public String testSubmitted(Model model) {
	List<AdminCourse> course=admincourseDao.listOfCourses(model);
	 model.addAttribute("courseDetail", course);

	return "CourseList";
}
@RequestMapping("/Rated")
public String getRating(@ModelAttribute("Feedback")Feedback feed) {
	return "Rated";
}
@GetMapping("/EnrolledVideos")
public String getEnrolledVideos(Model model,HttpSession session) {
	learnerDao.getEnrolledVideos(session, model);
	return "EnrollVideo";
}

}

	
