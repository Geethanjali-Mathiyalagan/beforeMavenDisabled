package com.project.elearning.interfcae;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.project.elearning.pojo.Admin;

public interface AdminInterface {
	public Boolean adminLogin(Admin admin,HttpSession session);
	public Integer totalLearnerCount();
	public Integer totalInstructorCount();
	public Integer totalCourses();
	public Integer totalIncome();
	public Integer countOfMaximumCourse();
	public String countOfMaximumCourseName();
	public Integer countOfMinimumCourse();
	public String countOfMinimumCourseName();
}
