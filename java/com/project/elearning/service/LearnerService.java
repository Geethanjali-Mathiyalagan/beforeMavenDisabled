package com.project.elearning.service;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.dao.LearnerDao;
import com.project.elearning.exception.MailIdException;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.CourseSelect;
import com.project.elearning.pojo.Feedback;
import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Learner;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Video;

@Service
public class LearnerService {

LearnerDao learnerDao = new LearnerDao();
	public void addLearnerDetails(Learner learn,HttpSession session) {
		learnerDao.insertLearnerDetails(learn, session);	
	}
	
	public void learnerLogin(Learner learn,HttpSession session) {
		learnerDao.learnerLogin(learn, session);
	}
	public void listCourse(Integer categoryId, Model model,HttpSession session) {
List<CourseSelect> selectedList = learnerDao.viewSelectedCourse(categoryId, session, model);
		model.addAttribute("SelectedList", selectedList);
	
	}
	
	public void deatailOfCourse(Model model,Instructors instruct) throws JsonProcessingException {
		List<Instructors> courseDetail = learnerDao.courseDetails(instruct, model);
		model.addAttribute("CourseDetails", courseDetail);	
	}
	public void enrollCourse(CourseEnroll course,HttpSession session) {
		learnerDao.insertCoursePayment(course, session);	
	}
	public void courseEnrolling(CourseEnroll course,HttpSession session) {
		learnerDao.insertCoursePayment(course, session);	
	}
	public void addScore(Mark mark) {
		learnerDao.insertMarks(mark);
	}
	
	public void takeScriptVideo(Model model,HttpSession session) {
		List<Video> script=learnerDao.getCourseVideos(session, model);
		model.addAttribute("video1",script);
	}
	
	public Boolean mailCheck(Learner learn,Model model)  {
		return learnerDao.checkMail(learn, model);
	}

	
	public void listUesr(Model model) {
		List<Learner> users = learnerDao.viewUserList(model);
		model.addAttribute("userList", users);
	}
	
	public void scoreInsert(Mark mark) {
		learnerDao.insertMarks(mark);
	}
	public void giveRatings(Feedback feed) {
		learnerDao.insertReview(feed);
	}
	public void feedbackList(Model model) {
		List<Feedback>feedbcak=learnerDao.getFeedbacks(model);
		model.addAttribute("feedback", feedbcak);
	}
}

