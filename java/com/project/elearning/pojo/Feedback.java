package com.project.elearning.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Feedback {
	private Integer learnerId;
	private Integer instructorId;
	private String learnerName;
	private String review;
	private String ratings;
	public Feedback() {
		super();
		
	}
	
	
	@Override
	public String toString() {
		return "Feedback [learnerId=" + learnerId + ", instructorId=" + instructorId + ", learnerName=" + learnerName
				+ ", review=" + review + ", ratings=" + ratings + "]";
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


	public String getLearnerName() {
		return learnerName;
	}


	public void setLearnerName(String learnerName) {
		this.learnerName = learnerName;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public String getRatings() {
		return ratings;
	}


	public void setRatings(String ratings) {
		this.ratings = ratings;
	}



}
