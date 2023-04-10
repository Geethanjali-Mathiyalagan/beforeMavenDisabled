package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Mark;

public class MarkMapper implements RowMapper<Mark>{

	@Override
	public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
	Mark mark = new Mark();
	
	Integer learnerId=rs.getInt("learnerId");
	Integer score=rs.getInt("score");
	
    Float percentage=rs.getFloat("percentage");
    
    mark.setLearnerId(learnerId);
    mark.setScore(score);
    
    mark.setPercentage(percentage);
	
		return mark;
	}

}
