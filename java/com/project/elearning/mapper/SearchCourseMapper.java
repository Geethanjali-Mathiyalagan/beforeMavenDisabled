package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.AdminCourse;

public class SearchCourseMapper implements RowMapper<AdminCourse> {

	@Override
	public AdminCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
	AdminCourse admincourse=new AdminCourse();
	Integer categoryId=rs.getInt("catgeoryId");
	Integer amount=rs.getInt("amount");
	
	admincourse.setCategeoryId(categoryId);
    admincourse.setAmount(amount);
	return   admincourse;
	}

}
