package com.project.elearning.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.elearning.connection.ConnectionUtil;
import com.project.elearning.interfcae.AdminInstructorDaoInterface;
import com.project.elearning.pojo.AdminInstructor;


public class AdminInstructorDao implements AdminInstructorDaoInterface {

JdbcTemplate jdbc =ConnectionUtil.getJdbcTemplate();
 Logger logger=LoggerFactory.getLogger(AdminInstructorDao.class);
 
public void insertInstructorDetails(AdminInstructor instruct) {
	String insert="insert into Instructors (categoriesId,instructorId,instructorName,instructorMailId,instructorPassword,experience,ratingOfInstructor,durationOfCourse)values(?,?,?,?,?,?,?,?)";
	Object[] insertInstructor= {instruct.getCategoriesIds(),instruct.getInstructorIds(),instruct.getInstructorNames(),instruct.getInstructorMailIds(),instruct.getInstructorPasswords(),instruct.getExperiences(),instruct.getRatingOfInstructors(),instruct.getDurationOfCourses()};
	jdbc.update(insert, insertInstructor);
	
	
}
public String updateInstructorDetails(AdminInstructor instruct) {
	String update="update Instructors set instructorname=? where instructorId=?";
	Object[] updation= {instruct.getInstructorNames(),instruct.getInstructorIds()};
	jdbc.update(update, updation);
	
	return update;
}

public void deleteInstrcutorDetails(AdminInstructor instruct) {
	String delete="delete from Instructors where instructorId=?";
	Object[] deletion= {instruct.getInstructorIds()};
	jdbc.update(delete, deletion);
	
}

}
