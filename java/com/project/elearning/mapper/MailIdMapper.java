package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Learner;

public class MailIdMapper implements RowMapper<Learner>{

	@Override
	public Learner mapRow(ResultSet rs, int rowNum) throws SQLException {
		Learner learning=new Learner();
		   String email=rs.getString("learnerMailId");
	      learning.setLearnerMailId(email);
	        return learning;
	   
	}

}
