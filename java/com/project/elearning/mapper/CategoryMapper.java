package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.CourseSelect;

public class CategoryMapper implements RowMapper<CourseSelect> {

	@Override
	public CourseSelect mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseSelect course= new CourseSelect();
		Integer categoryId = rs.getInt("CategoryId");
		
		course.setCategoryId(categoryId);
		return course;
	}

}
