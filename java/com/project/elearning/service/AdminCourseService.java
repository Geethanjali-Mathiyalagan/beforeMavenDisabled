package com.project.elearning.service;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.dao.AdminCourseDao;
import com.project.elearning.dao.AdminDao;
import com.project.elearning.dao.InstructorDao;
import com.project.elearning.dao.LearnerDao;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.Admin;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.CourseSelect;
import com.project.elearning.pojo.Feedback;
import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Learner;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Test;


@Service
public class AdminCourseService {

AdminDao adminDao=new AdminDao();

AdminCourseDao admincourseDao= new AdminCourseDao();

LearnerDao dao=new LearnerDao();

InstructorDao instructorDao=new InstructorDao();


public Boolean adminLogin(Admin admin,HttpSession session) {
	return adminDao.adminLogin(admin,session);
}
	public void getCategories(Model model) {
		List<AdminCourse> course=admincourseDao.listOfCourses(model);
		 model.addAttribute("courseDetail", course);
	}
	
	public void getInstructors(Model model) throws JsonProcessingException {
		List<Instructors> instructor=admincourseDao.listOfInstructors(model);
		model.addAttribute("InstructorDetail", instructor);
	}
	public void removeLearners(Learner learn) {
		dao.removeLearner(learn);
	}
	public void paymentList(Model model) {
		List<CourseEnroll> course=admincourseDao.listOfPayment(model);
		model.addAttribute("payment", course);	
	}
	
	public void  takePercentage(Model model,HttpSession session) {
		List<Mark> marks=dao.getPercentage(session, model);
		
		model.addAttribute("Marks",marks);	
	}
	public void insertRatings(Feedback feed) {
		dao.insertReview(feed);
	}
	public void addCourseDetails(AdminCourse course) {
		admincourseDao.insertCourseDetails(course);
	}
	
	public void updateCoursesName(AdminCourse course) {
		admincourseDao.updateCourse(course);
	}
	
	public void removeCourseName(AdminCourse course) {
		admincourseDao.deleteCourse(course);
	}
	
	public void addQuestions(Test test) {
		instructorDao.insertQuestions(test);	
	}
	public void questionsUpdate(Test test) {
		instructorDao.updateQuestions(test);
	}
public void learnerCount(Model model) {
	Integer totalCount=adminDao.totalLearnerCount();
	 model.addAttribute("LearnerCount", totalCount);
}
public void instructorCount(Model model) {
	Integer countInstructors=adminDao.totalInstructorCount();
	model.addAttribute("InstructorCount", countInstructors);
}
public void coursesCount(Model model) {
	Integer countCourses=adminDao.totalCourses();
	model.addAttribute("CourseCount", countCourses);
}
	public void incomeCount(Model model) {
		Integer countIncome=adminDao.totalIncome();
		model.addAttribute("Income", countIncome);	
	}
	public void maximumCourseCount(Model model) {
		Integer count=adminDao.countOfMaximumCourse();
		model.addAttribute("Count", count);
	}
	public void maximumChoosedCourse(Model model) {
		String count=adminDao.countOfMaximumCourseName();
		model.addAttribute("CourseName", count);
	}
	public void minimumCourseCount(Model model) {
		Integer count=adminDao.countOfMinimumCourse();
		model.addAttribute("MinCount", count);
	}
	public void minimumChoosedCourse(Model model) {
		String count=adminDao.countOfMinimumCourseName();
		model.addAttribute("MinCountCourseName", count);
	}
	public void learnerList(Model model) {
		List<Mark> mark=instructorDao.learnersList(model);
		model.addAttribute("Learner", mark);	
	}
	public void courseUpdate(AdminCourse course) {
		admincourseDao.updateCourse(course);
	}
	public void courseRemove(AdminCourse course) {
		admincourseDao.deleteCourse(course);
	}
	public void questionInsert(Test test) {
		instructorDao.insertQuestions(test);
	}
	public void questionUpdate(Test test) {
		instructorDao.updateQuestions(test);
	}
	public void addCourses(CourseSelect courseSelect) {
		admincourseDao.insertCourse(courseSelect);
	}
}
