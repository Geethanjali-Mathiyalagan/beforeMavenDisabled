package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.CourseSelect;

public class DynamicCourseMapper implements RowMapper<CourseSelect> {

	@Override
	public CourseSelect mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseSelect courseSelect=new CourseSelect();
		String courseName=rs.getString("courseName");
		
		courseSelect.setCourseName(courseName);
		return courseSelect;
	}

}
