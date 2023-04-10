package com.project.elearning.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class AdminInstructor {
	private Integer categoriesIds;
	private Integer instructorIds;
	private String instructorNames;
	private String instructorMailIds;
	private String instructorPasswords;
	private String experiences;
	private String  ratingOfInstructors ;
	private String ratingOfCourses; 
	private String durationOfCourses;
	public Integer getCategoriesIds() {
		return categoriesIds;
	}
	public void setCategoriesIds(Integer categoriesIds) {
		this.categoriesIds = categoriesIds;
	}
	public Integer getInstructorIds() {
		return instructorIds;
	}
	public AdminInstructor() {
		super();
	}
	public void setInstructorIds(Integer instructorIds) {
		this.instructorIds = instructorIds;
	}
	public String getInstructorNames() {
		return instructorNames;
	}
	public void setInstructorNames(String instructorNames) {
		this.instructorNames = instructorNames;
	}
	public String getInstructorMailIds() {
		return instructorMailIds;
	}
	public void setInstructorMailIds(String instructorMailIds) {
		this.instructorMailIds = instructorMailIds;
	}
	public String getInstructorPasswords() {
		return instructorPasswords;
	}
	public void setInstructorPasswords(String instructorPasswords) {
		this.instructorPasswords = instructorPasswords;
	}
	public String getExperiences() {
		return experiences;
	}
	public void setExperiences(String experiences) {
		this.experiences = experiences;
	}
	public String getRatingOfInstructors() {
		return ratingOfInstructors;
	}
	public void setRatingOfInstructors(String ratingOfInstructors) {
		this.ratingOfInstructors = ratingOfInstructors;
	}
	public String getRatingOfCourses() {
		return ratingOfCourses;
	}
	public void setRatingOfCourses(String ratingOfCourses) {
		this.ratingOfCourses = ratingOfCourses;
	}
	public String getDurationOfCourses() {
		return durationOfCourses;
	}
	public void setDurationOfCourses(String durationOfCourses) {
		this.durationOfCourses = durationOfCourses;
	}
	@Override
	public String toString() {
		return "AdminInstructorPojo [categoriesIds=" + categoriesIds + ", instructorIds=" + instructorIds
				+ ", instructorNames=" + instructorNames + ", instructorMailIds=" + instructorMailIds
				+ ", instructorPasswords=" + instructorPasswords + ", experiences=" + experiences
				+ ", ratingOfInstructors=" + ratingOfInstructors + ", ratingOfCourses=" + ratingOfCourses
				+ ", durationOfCourses=" + durationOfCourses + "]";
	}
	
}
