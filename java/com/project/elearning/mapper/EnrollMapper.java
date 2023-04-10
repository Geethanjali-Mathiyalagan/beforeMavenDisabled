package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.CourseEnroll;

public class EnrollMapper implements RowMapper<CourseEnroll> {

	@Override
	public CourseEnroll mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseEnroll course=new CourseEnroll();
		
		Integer learnerId=rs.getInt("learnerId");
		Integer categoryId=rs.getInt("categoryId");
		
		String courseName=rs.getString("courseName");
		
		
		
		course.setLearnerId(learnerId);
		course.setCategoryId(categoryId);
		
		course.setCourseName(courseName);
		
		return course;
		
		
	}

}
