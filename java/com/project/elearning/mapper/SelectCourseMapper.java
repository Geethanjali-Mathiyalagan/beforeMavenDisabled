package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Instructors;

public class SelectCourseMapper implements RowMapper<Instructors>{

	@Override
	public Instructors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructors instruct=new Instructors();
		Integer categoriesId=rs.getInt("categoriesId");
		Integer instructorId=rs.getInt("instructorId");
		String instructorName=rs.getString("instructorName");
		String experience=rs.getString("experience");
		String ratingOfInstructor=rs.getString("ratingOfInstructor");
		
		String durationOfCourse=rs.getString("durationOfCourse");
		String instructorCode=rs.getString("instructorCode");
		
		
		instruct.setCategoriesId(categoriesId);
		instruct.setInstructorId(instructorId);
		instruct.setInstructorName(instructorName);
		instruct.setExperience(experience);
		instruct.setRatingOfInstructor(ratingOfInstructor);
		
		instruct.setDurationOfCourse(durationOfCourse);
		instruct.setInstructorCode(instructorCode);
		return instruct;
	}

}
