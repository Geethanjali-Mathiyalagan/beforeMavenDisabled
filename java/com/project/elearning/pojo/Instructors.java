package com.project.elearning.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Instructors {
	private Integer categoriesId;
	private Integer instructorId ;
	private String instructorName; 
	private String instructorMailId;
	private String instructorPassword;
	private String experience ;
	private String ratingOfInstructor;
	private String durationOfCourse;
	private String ratingOfCourse;
	private String instructorCode;
	public Instructors() {
		super();
		
	}
	
	
	@Override
	public String toString() {
		return "InstructorDetailPojo [categoriesId=" + categoriesId + ", instructorId=" + instructorId
				+ ", instructorName=" + instructorName + ", instructorMailId=" + instructorMailId
				+ ", instructorPassword=" + instructorPassword + ", experience=" + experience + ", ratingOfInstructor="
				+ ratingOfInstructor + ", durationOfCourse=" + durationOfCourse + ", ratingOfCourse=" + ratingOfCourse
				+ ", instructorCode=" + instructorCode + "]";
	}


	public Integer getCategoriesId() {
		return categoriesId;
	}


	public void setCategoriesId(Integer categoriesId) {
		this.categoriesId = categoriesId;
	}


	public Integer getInstructorId() {
		return instructorId;
	}


	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}


	public String getInstructorName() {
		return instructorName;
	}


	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}


	public String getInstructorMailId() {
		return instructorMailId;
	}


	public void setInstructorMailId(String instructorMailId) {
		this.instructorMailId = instructorMailId;
	}


	public String getInstructorPassword() {
		return instructorPassword;
	}


	public void setInstructorPassword(String instructorPassword) {
		this.instructorPassword = instructorPassword;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getRatingOfInstructor() {
		return ratingOfInstructor;
	}


	public void setRatingOfInstructor(String ratingOfInstructor) {
		this.ratingOfInstructor = ratingOfInstructor;
	}


	public String getDurationOfCourse() {
		return durationOfCourse;
	}


	public void setDurationOfCourse(String durationOfCourse) {
		this.durationOfCourse = durationOfCourse;
	}


	public String getRatingOfCourse() {
		return ratingOfCourse;
	}


	public void setRatingOfCourse(String ratingOfCourse) {
		this.ratingOfCourse = ratingOfCourse;
	}


	public String getInstructorCode() {
		return instructorCode;
	}


	public void setInstructorCode(String instructorCode) {
		this.instructorCode = instructorCode;
	}



}
