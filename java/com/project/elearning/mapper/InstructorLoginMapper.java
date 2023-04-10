package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.project.elearning.pojo.Instructors;



public class InstructorLoginMapper implements RowMapper<Instructors>{

	@Override
	public Instructors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructors instruct=new Instructors();
		Integer instructorId=rs.getInt("instructorId");
		String instructorPassword=rs.getString("instructorPassword");
		
		instruct.setInstructorId(instructorId);
		instruct.setInstructorPassword(instructorPassword);
		
		return instruct;
	}

}
