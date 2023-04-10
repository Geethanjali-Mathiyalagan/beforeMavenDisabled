package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Learner;

public class LearnerIdMapper implements RowMapper<Learner> {

	@Override
	public Learner mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Learner learn= new Learner();
		Integer learnerId=rs.getInt("learnerId");
		
		learn.setLearnerId(learnerId);
		
		return learn;
	}

}
