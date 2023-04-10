package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Learner;

public class LearnerMapper implements RowMapper<Learner> {

	@Override
	public Learner mapRow(ResultSet rs, int rowNum) throws SQLException {
		Learner learn=new Learner();
		int learnerId=rs.getInt("learnerId");
		String learnerName=rs.getString("learnerName");
		String learnerPassword=rs.getString("learnerPassword");
		learn.setLearnerId(learnerId);
		learn.setLearnerName(learnerName);
		learn.setLearnerPassword(learnerPassword);
		
		return learn;
	}

}
