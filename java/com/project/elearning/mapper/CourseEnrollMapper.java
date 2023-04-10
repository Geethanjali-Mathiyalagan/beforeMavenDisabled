package com.project.elearning.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;




import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.CourseEnroll;

public class CourseEnrollMapper implements RowMapper<CourseEnroll>{

	@Override
	public CourseEnroll mapRow(ResultSet rs, int rowNum) throws SQLException {

		
		CourseEnroll course=new CourseEnroll();
		
		Integer learnerId=rs.getInt("learnerId");
		Integer categoryId=rs.getInt("categoryId");
		Integer instructorId=rs.getInt("instructorId");
		String courseName=rs.getString("courseName");
		String paymentType=rs.getString("paymentType");
		Long paymentDetail=rs.getLong("paymentDetail");
		Date enroll=rs.getDate("enroll");
		Integer amount=rs.getInt("amount");
		
		course.setLearnerId(learnerId);
		course.setCategoryId(categoryId);
		course.setInstructorId(instructorId);
		course.setCourseName(courseName);
		course.setPaymentType(paymentType);
		course.setPaymentDetail(paymentDetail);
		course.setEnroll(enroll);
		course.setAmount(amount);
		return course;
	}

}
