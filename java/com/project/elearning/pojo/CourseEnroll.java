package com.project.elearning.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;
@Repository
public class CourseEnroll {
private Integer learnerId;
private Integer categoryId;
private Integer instructorId;
private String courseName;
private String paymentType;
private Long paymentDetail;
private String paymentStatus;
private Integer paymentId;
private Date enroll;
private Integer amount;
private Integer courseCount;


public Integer getPaymentId() {
	return paymentId;
}
public void setPaymentId(Integer paymentId) {
	this.paymentId = paymentId;
}
public Integer getCourseCount() {
	return courseCount;
}
public void setCourseCount(Integer courseCount) {
	this.courseCount = courseCount;
}
public Date getEnroll() {
	return enroll;
}
public void setEnroll(Date enroll) {
	this.enroll = enroll;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}

public void setPaymnetId(Integer paymnetId) {
	this.paymentId = paymnetId;
}
public CourseEnroll() {
	super();
	
}
   

@Override
public String toString() {
	return "CourseEnroll [learnerId=" + learnerId + ", categoryId=" + categoryId + ", instructorId=" + instructorId
			+ ", courseName=" + courseName + ", paymentType=" + paymentType + ", paymentDetail=" + paymentDetail
			+ ", paymentStatus=" + paymentStatus + ", paymentId=" + paymentId + ", enroll=" + enroll + ", amount="
			+ amount + ", courseCount=" + courseCount + "]";
}
public Integer getLearnerId() {
	return learnerId;
}
public void setLearnerId(Integer learnerId) {
	this.learnerId = learnerId;
}
public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
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
public String getPaymentType() {
	return paymentType;
}
public void setPaymentType(String paymentType) {
	this.paymentType = paymentType;
}
public Long getPaymentDetail() {
	return paymentDetail;
}
public void setPaymentDetail(Long paymentDetail) {
	this.paymentDetail = paymentDetail;
}
public String getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}

}
