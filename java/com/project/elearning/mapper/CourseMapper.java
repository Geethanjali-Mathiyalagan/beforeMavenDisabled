package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.CourseEnroll;

public class CourseMapper implements RowMapper<CourseEnroll>{

	@Override
	public CourseEnroll mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseEnroll course = new CourseEnroll();
		String courseName = rs.getString("courseName");
		
		course.setCourseName(courseName);
	
		return course;
	}

}
