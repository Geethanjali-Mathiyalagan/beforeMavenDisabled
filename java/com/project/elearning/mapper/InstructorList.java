package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Instructors;


public class InstructorList implements RowMapper<Instructors>{

	@Override
	public Instructors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructors instructor=new Instructors();
		Integer categoriesId=rs.getInt("categoriesId");
		Integer instructorId=rs.getInt("instructorId");
		String instructorName=rs.getString("instructorName");
		String instructorMailId=rs.getString("instructorMailId");
		String experience=rs.getString("experience");
		String ratingOfInstructor=rs.getString("ratingOfInstructor");
		
		String durationOfCourse=rs.getString("durationOfCourse");

		
		
		instructor.setCategoriesId(categoriesId);
		instructor.setInstructorId(instructorId);
		instructor.setInstructorName(instructorName);
		instructor.setInstructorMailId(instructorMailId);
		instructor.setExperience(experience);
		instructor.setRatingOfInstructor(ratingOfInstructor);
		
		instructor.setDurationOfCourse(durationOfCourse);
		
		return instructor;
	}

}
