package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Test;

public class TestMapper implements RowMapper<Test> {

	@Override
	public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
		Test test = new Test();
		String correctAnswer=rs.getString("correctAnswer");
		
		test.setCorrectAnswer(correctAnswer);
		return test;
	}

}
