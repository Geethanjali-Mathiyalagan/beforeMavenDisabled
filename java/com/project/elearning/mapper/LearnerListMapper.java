package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Learner;

public class LearnerListMapper implements RowMapper<Learner> {

	@Override
	public Learner mapRow(ResultSet rs, int rowNum) throws SQLException {
		Learner listLearner=new Learner();
		int learnerId=rs.getInt("learnerId");
		String learnerName=rs.getString("learnerName");
		String learnerMailId=rs.getString("learnerMailId");
		String learnerPassword=rs.getString("learnerPassword");
		
		listLearner.setLearnerId(learnerId);
		listLearner.setLearnerName(learnerName);
		listLearner.setLearnerMailId(learnerMailId);
		listLearner.setLearnerPassword(learnerPassword);
		return listLearner;
	}

}
