package com.project.elearning.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Test {
	private Integer instructorId;
	private String courseName;
	private Integer questionNo;
	private String question;
	private String option;
	private String option1;
	private String option2;
	private String option3;
	private String correctAnswer;
	public Integer getQuestionNo() {
		return questionNo;
	}
	public Test() {
		super();
	}
	
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	@Override
	public String toString() {
		return "Test [instructorId=" + instructorId + ", courseName=" + courseName + ", questionNo=" + questionNo
				+ ", question=" + question + ", option=" + option + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", correctAnswer=" + correctAnswer + "]";
	}
	public Integer getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}
	

}
