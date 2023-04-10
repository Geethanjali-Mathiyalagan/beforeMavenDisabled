package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.CourseSelect;

public class CourseSelectedMapper implements RowMapper<CourseSelect>{

	@Override
	public CourseSelect mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseSelect course=new CourseSelect();
		Integer categoryId=rs.getInt("categoryId");

		String courseName=rs.getString("courseName");
		
	
		
		String durationOfCourse=rs.getString("durationOfCourse");
		
		String modules=rs.getString("Moduels");
		
		course.setCategoryId(categoryId);

		course.setCourseName(courseName);
		
		course.setDurationOfCourse(durationOfCourse);
		course.setModules(modules);
		
		return course;
	}

}