package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.AdminCourse;

public class AmountMapper implements RowMapper<AdminCourse>{

	@Override
	public AdminCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminCourse course=new AdminCourse();
		
		Integer amount=rs.getInt("amount");
		
		
		

		course.setAmount(amount);
		
		return course;
	}

}