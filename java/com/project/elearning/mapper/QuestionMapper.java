package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Test;

public class QuestionMapper implements RowMapper<Test> {

	@Override
	public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
		Test test= new Test();
	Integer instructorId=rs.getInt("instructorId");
	String courseName=rs.getString("courseName");
	Integer questionNo =rs.getInt("questionNo");
	String question=rs.getString("question");
	String option1=rs.getString("option1");
	String option2=rs.getString("option2");
	String option3=rs.getString("option3");
	String correctAnswer=rs.getString("correctAnswer");
	
	test.setInstructorId(instructorId);
	test.setCourseName(courseName);
	test.setQuestionNo(questionNo);
	test.setQuestion(question);
	test.setOption1(option1);
	test.setOption2(option2);
	test.setOption3(option3);
	test.setCorrectAnswer(correctAnswer);
	return test;
	}

}
