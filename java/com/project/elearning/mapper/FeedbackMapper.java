package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Feedback;

public class FeedbackMapper implements RowMapper<Feedback> {

	@Override
	public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
	Feedback feed = new Feedback();
	String learnerName=rs.getString("learnerName");
	String review=rs.getString("review");
	String ratings=rs.getString("ratings");
	
	feed.setLearnerName(learnerName);	
	feed.setReview(review);
	feed.setRatings(ratings);
	
	
	return feed;
	}

}
