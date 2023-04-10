package com.project.elearning.interfcae;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.exception.MailIdException;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.CourseSelect;
import com.project.elearning.pojo.Feedback;
import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Learner;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Video;

public interface LearnerDaoInterface {
	public void insertLearnerDetails(Learner learn,HttpSession session);
	public void updateLearner(Learner learn);
	public void removeLearner(Learner learn) ;
	public boolean checkMail(Learner learn,Model model);
	public Boolean learnerLogin(Learner learn ,HttpSession session);
	public List<Mark> getPercentage(HttpSession session,Model model);
	public List<AdminCourse> searchCourse(HttpSession session);
	public List<Learner> viewUserList(Model model);
	public List<CourseSelect> viewSelectedCourse(Integer categoryId,HttpSession session,Model model);
	public List<Instructors> courseDetails(Instructors instruct,Model model)throws JsonProcessingException;
	public void insertCoursePayment(CourseEnroll course,HttpSession session);
	public void insertCoursePayment1(CourseEnroll course,HttpSession session);
	public List<Video>getCourseVideos(HttpSession session,Model model);
	public void insertMarks(Mark mark);
	public void insertReview(Feedback feedback);
}
