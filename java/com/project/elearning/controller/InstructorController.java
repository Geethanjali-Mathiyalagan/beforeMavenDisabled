package com.project.elearning.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.dao.InstructorDao;
import com.project.elearning.pojo.CourseEnroll;

import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Test;
import com.project.elearning.pojo.Instructor;
import com.project.elearning.pojo.Video;
import com.project.elearning.service.AdminCourseService;
import com.project.elearning.service.InstructorService;

@Controller
public class InstructorController {
	
	InstructorService service =new InstructorService();
	AdminCourseService services = new AdminCourseService();
	InstructorDao dao = new InstructorDao();
	
	@RequestMapping("/addVideos")
	public ModelAndView addVideo(@ModelAttribute("addVideos")Video videos,HttpSession session,Model model) {
		Integer instructorId=(Integer) session.getAttribute("Instruct");
		ModelAndView modelAndView = new ModelAndView("InsertVideo");
	    modelAndView.addObject("message", instructorId);
	    List<String>list=dao.dynamicCourseName();
		  model.addAttribute("dynamic",list);
	   
	    return modelAndView;
		
	
	}
	
	
	@PostMapping("/insertJavaScriptVideo")
	public String insertJavaScript(Model model,@RequestParam("videos") MultipartFile videos,@RequestParam("instructorId")Integer instructorId,@RequestParam("courseName")String courseName,@RequestParam("descriptionOfVideo")String descriptionOfVideo) throws IOException {
	
	
		Video videoInsert=new Video(); 
		 
	        String filename = videos.getOriginalFilename();
	     try( FileInputStream fin=new FileInputStream("C:\\Users\\geet3334\\eclipse-workspace\\OnlineLearning\\src\\main\\resources\\static\\Video\\"+filename);){
	    	 byte[] videos2 = fin.readAllBytes();
	    	 videoInsert.setVideos(videos2);
	    	 
	     }
	       videoInsert.setInstructorId(instructorId);
	       videoInsert.setCourseName(courseName);
           videoInsert.setDescriptionOfVideo(descriptionOfVideo);
           service.addJavaScript(videoInsert);
				       
	Integer id=videoInsert.getInstructorId();	
	Integer count=dao.particularInstructorLearnerCount(id);
	model.addAttribute("instCount", count);
	Integer count1=dao.testLearnersCount(id);
	model.addAttribute("testCount",count1);
	service.learnersCount(model);
	return "InstructorDashboard";
		}
	
	
	
	
	
	@PostMapping("/updateVideo")
	public String updateVideoDetail(@RequestParam("video")String video,@RequestParam("videoDetails")String videoDetails,Model model) {
		
		Instructor instructor=new Instructor();
		instructor.setVideo(null);
		instructor.setVideoDetails(videoDetails);
		service.videosUpdate(instructor);
		return "redirect:/list" ;
		
	}
	@PostMapping("/deleteVideo")
	public String deleteVideoDetail(@RequestParam("videoDetails")String videoDetails) {
		
		Instructor instructor=new Instructor();
		instructor.setVideoDetails(videoDetails);
		service.videoDelete(instructor);
		return "redirect:/list";
		
		
	}
	
	@RequestMapping("/LoginInstructor")
	public String loginInstructor(@ModelAttribute("InstructorLogin")Instructors instruct) {
		return "InstructorLogin";
	}
	
	
	@PostMapping("/InstructorLogin")
	public String loginInstructor(@ModelAttribute("InstructorLogin")Instructors instruct,Model model,HttpSession session) {
		
		
		
		
		if(Boolean.TRUE.equals(service.instructorLogin(instruct, session))) {
			
			Integer id=instruct.getInstructorId();
			session.setAttribute("Instruct",instruct.getInstructorId());
			
			 Integer count=dao.particularInstructorLearnerCount(id);
			 model.addAttribute("instCount",count);
			 Integer count1=dao.testLearnersCount(id);
			  model.addAttribute("testCount",count1);
			  model.addAttribute("Id1", id);
			  service.learnersCount(model);
			 
			 
			return"InstructorDashboard";
		}
		
		else if(Boolean.FALSE.equals(service.instructorLogin(instruct, session))) {
			return"index";
		}
		else {
			return "InstructorLogin";
		}
	
			
		}
	
	
	
	
	
	
	  @GetMapping("/dynamicDropdown")
	  public String dynamicPartyName(@ModelAttribute("course")CourseEnroll courses,HttpSession session,Model model)
	  {
	   
	  return "addquestions"; 
	  }
	 
	
	@GetMapping("/learners")
	public String getList(Model model,HttpSession session) {
		service.listOfLearners(model,session); 
		return "InstructorLearner";
		
	
	}
	@GetMapping("/listCourse")
	public String getCourse(Model model,HttpSession session) {
		
	service.getCourseList(model,session);
	return "Course";
	}


	@GetMapping("/listOfQuestions")
	public String getQuestions(Model model,HttpSession session) {
		
		service.questionList(model, session);
	
		return "QuestionList";
	}
	
@GetMapping("/getVideos")
public String getVideoList(Model model,HttpSession session) {
service.listVideos(model, session);
return "Videos";

}

@GetMapping("/listOfLearners")
public String getLearnerList(Model model,HttpSession session) throws JsonProcessingException {
	service.learnerList(model, session);
	return "LearnerList";
}
}
