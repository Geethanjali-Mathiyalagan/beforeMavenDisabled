package com.project.elearning.interfcae;

import java.util.List;

import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.Instructors;

public interface AdminCourseDaoInterface {
	public void insertCourseDetails(AdminCourse course);
	public void updateCourse(AdminCourse course);
	public void deleteCourse(AdminCourse course);
	public List<AdminCourse>listOfCourses(Model model);
	public List<Instructors>listOfInstructors(Model model)throws JsonProcessingException;
	
}
