package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.AdminCourse;

public class AdminCourseMapper implements RowMapper<AdminCourse> {

	@Override
	public AdminCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminCourse course=new AdminCourse();
		Integer categoryId=rs.getInt("categoryId");
		String categoryName=rs.getString("categoryName");
		String descriptions=rs.getString("descriptions");
		Integer amount=rs.getInt("amount");
		
		byte[] image=rs.getBytes("image");
		

		String base64Videos = Base64.getEncoder().encodeToString(image); 
		
		course.setCategeoryId(categoryId);
		course.setCategoryName(categoryName);
		course.setDescriptions(descriptions);
		course.setAmount(amount);
		course.setImagePath(base64Videos);
		return course;
	}

}
