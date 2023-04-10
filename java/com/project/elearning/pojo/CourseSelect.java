package com.project.elearning.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class CourseSelect {
	
	private Integer categoryId;
	private String categoryName;
	private String courseName;
	private String ratingOfCourse;
	private String durationOfCourse;
	private String modules;
	public CourseSelect() {
		super();
	}
	@Override
	public String toString() {
		return "CourseSelectPojo [categoryId=" + categoryId + ", categoryName=" + categoryName + ", courseName="
				+ courseName + ", ratingOfCourse=" + ratingOfCourse + ", durationOfCourse=" + durationOfCourse
				+ ", modules=" + modules + "]";
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getRatingOfCourse() {
		return ratingOfCourse;
	}
	public void setRatingOfCourse(String ratingOfCourse) {
		this.ratingOfCourse = ratingOfCourse;
	}
	public String getDurationOfCourse() {
		return durationOfCourse;
	}
	public void setDurationOfCourse(String durationOfCourse) {
		this.durationOfCourse = durationOfCourse;
	}
	public String getModules() {
		return modules;
	}
	public void setModules(String modules) {
		this.modules = modules;
	}

}
