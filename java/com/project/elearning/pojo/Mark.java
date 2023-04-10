package com.project.elearning.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Mark {
	private Integer learnerId;
	private Integer instructorId;
	private Integer score;
	private String grade;
	private Float percentage;
	
	public Mark() {
		super();

	}
	@Override
	public String toString() {
		return "MarkPojo [learnerId=" + learnerId + ", instructorId=" + instructorId + ", score=" + score + ", grade="
				+ grade + ", percentage=" + percentage + "]";
	}
	public Integer getLearnerId() {
		return learnerId;
	}
	public void setLearnerId(Integer learnerId) {
		this.learnerId = learnerId;
	}
	public Integer getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

}
