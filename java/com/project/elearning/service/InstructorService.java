package com.project.elearning.service;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.dao.AdminDao;
import com.project.elearning.dao.InstructorDao;
import com.project.elearning.dao.LearnerDao;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.CourseEnroll;

import com.project.elearning.pojo.Instructor;
import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Test;
import com.project.elearning.pojo.Video;

@Service
public class InstructorService {
	
	InstructorDao instructorDao= new InstructorDao();

	LearnerDao learnerDao=new LearnerDao();
	
	AdminDao adminDao=new AdminDao();
	public void addJavaScript(Video videos) {
		instructorDao.videoInserting(videos);	
	}
	
	public void videosUpdate(Instructor instructor) {
		instructorDao.updateVideo(instructor);
	}
	
	public void videoDelete(Instructor instructor) {
		instructorDao.deleteVideo(instructor);
	}
	
	public Boolean instructorLogin(Instructors instruct,HttpSession session) {
		return instructorDao.instructorLogin(instruct, session);	
	}
	
	public void getCourseList(Model model,HttpSession session) {
		
		List<AdminCourse>courses=learnerDao.searchCourse(session);
	    model.addAttribute("courseList",courses);
	}
	
	public void questionsRemove(Test test) {
		instructorDao.removeQuestions(test);
	}
	public void questionList(Model model,HttpSession session) {
		List<Test>question=instructorDao.listOfQuestions(session, model);
		model.addAttribute("questionList", question);
	}
	public void listVideos(Model model,HttpSession session) {
		List<Video>video=instructorDao.listOfVideo(session,model);
		model.addAttribute("videos", video);
	}
	
	public void learnerList(Model model,HttpSession session) throws JsonProcessingException {
		List<Mark> mark=instructorDao.listOfLearners(session,model);
		model.addAttribute("Learner", mark);
	}
	public void learnersUpdate(Mark mark) {
		instructorDao.updateLearnersList(mark);	
	}
	public void learnersCount(Model model) {
		Integer totalCount=adminDao.totalLearnerCount();
		 model.addAttribute("LearnerCount", totalCount);
	}
	public void listOfLearners(Model model,HttpSession session) {
		List<CourseEnroll>videos=adminDao.listLearners(session,model);
		model.addAttribute("Learners", videos);
	}
}
