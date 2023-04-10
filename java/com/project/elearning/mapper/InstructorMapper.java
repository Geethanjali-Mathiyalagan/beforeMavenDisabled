package com.project.elearning.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Base64;
import org.springframework.jdbc.core.RowMapper;
import com.project.elearning.pojo.Instructor;


public class InstructorMapper implements RowMapper<Instructor>{

	@Override
	public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructor  instruct=new Instructor();
		Integer instructorId=rs.getInt(1);
	    Integer categoryId=rs.getInt(2);
	    String courseName=rs.getString(3);
	    Integer videoId=rs.getInt(4);
	    String videoDetails=rs.getString(5);
	    byte[] video=rs.getBytes(6);
		String base64Videos = Base64.getEncoder().encodeToString(video); 
	    
	    instruct.setInstructorId(instructorId);	
	    instruct.setCategoryId(categoryId);
	    instruct.setCourseName(courseName);
	    instruct.setVideoId(videoId);
	    instruct.setVideoDetails(videoDetails);
	    instruct.setVideo(video);
	    
		instruct.setVideoPath(base64Videos);
	   
		
		
		return instruct;
	}

}

