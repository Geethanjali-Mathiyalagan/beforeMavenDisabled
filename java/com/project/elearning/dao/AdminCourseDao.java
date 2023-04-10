package com.project.elearning.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.elearning.connection.ConnectionUtil;
import com.project.elearning.interfcae.AdminCourseDaoInterface;
import com.project.elearning.mapper.AdminCourseMapper;
import com.project.elearning.mapper.CategoryMapper;
import com.project.elearning.mapper.CourseEnrollMapper;
import com.project.elearning.mapper.CourseSelectMapper;
import com.project.elearning.mapper.CourseSelectedMapper;
import com.project.elearning.mapper.InstructorList;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.CourseSelect;
import com.project.elearning.pojo.Instructors;


public class AdminCourseDao implements AdminCourseDaoInterface {

JdbcTemplate jdbc=ConnectionUtil.getJdbcTemplate();
public void insertCourseDetails(AdminCourse course) {
	String insert="insert into showcategories(categoryId,categoryName,descriptions,amount,image)values(?,?,?,?,?)";
	Object[] insertion= {course.getCategeoryId(),course.getCategoryName(),course.getDescriptions(),course.getAmount(),course.getImage()};
jdbc.update(insert, insertion);
	
}
public void insertCourse(CourseSelect courseSelect) {
	String addCourse="insert into CourseList(categoryId,courseName,durationOfCourse)values(?,?,?)";
	Object[] insertion= {courseSelect.getCategoryId(),courseSelect.getCourseName(),courseSelect.getDurationOfCourse()};
	jdbc.update(addCourse, insertion);
}

public void updateCourse(AdminCourse course) {
	String update="update showcategories set categoryName=?  where categoryId=?";
	Object[] updation= {course.getCategoryName(),course.getCategeoryId()};
	jdbc.update(update, updation);
	
}

public void deleteCourse(AdminCourse course) {
	String delete="delete from showcategories where categoryId=?";
	Object[] deletion= {course.getCategeoryId()};
	jdbc.update(delete, deletion);
	
}

public List<AdminCourse>listOfCourses(Model model){
	
	
	String courseList="select categoryId,categoryName,descriptions,amount,image from showcategories";
	
	
	  List<AdminCourse>listOfCourse = jdbc.query(courseList,new AdminCourseMapper());
      List<Map<String,Object>>request=new ArrayList<>();
      for(AdminCourse listOfCourseRequest:listOfCourse) {
         Map<String,Object>requestMap=new HashMap<>();
         requestMap.put("categoriesId",listOfCourseRequest.getCategeoryId()); 
         requestMap.put("categoryName", listOfCourseRequest.getCategoryName());
         requestMap.put("descriptions",listOfCourseRequest.getDescriptions());
         requestMap.put("amount",listOfCourseRequest.getAmount());
         requestMap.put("image", listOfCourseRequest.getImage());
        
         request.add(requestMap);
     }
     
  model.addAttribute("CategoryList",request);
  return listOfCourse;
  }

	


public List<Instructors>listOfInstructors(Model model) throws JsonProcessingException{
	String instructorList="select categoriesId,instructorId,instructorName,instructorMailId,experience,ratingOfInstructor,durationOfCourse from Instructors";
	
        List<Instructors>learnerList =jdbc.query(instructorList,new InstructorList());
        List<Map<String,Object>>request=new ArrayList<>();
        for(Instructors listOfRequest:learnerList) {
           Map<String,Object>requestMap=new HashMap<>();
           requestMap.put("categoriesId",listOfRequest.getCategoriesId()); 
           requestMap.put("instructorId", listOfRequest.getInstructorId());
           requestMap.put("instructorName",listOfRequest.getInstructorName());
           requestMap.put("instructorMailId", listOfRequest.getInstructorMailId());
           requestMap.put("experience", listOfRequest.getExperience());
           requestMap.put("ratingOfInstructor", listOfRequest.getRatingOfInstructor());
          
           requestMap.put("durationOfCourse", listOfRequest.getDurationOfCourse());
           request.add(requestMap);
       }
        ObjectMapper instruct=new ObjectMapper();
        String instructList=instruct.writeValueAsString(request);
    model.addAttribute("ViewRequest",instructList);
    return learnerList;
    }


public List<CourseEnroll>listOfPayment(Model model){
	String paymentList="select learnerId,categoryId,instructorId,courseName,paymentType,paymentDetail,enroll,amount from PaymentDetails";
	
	 List<CourseEnroll>paymentDetails = jdbc.query(paymentList,new CourseEnrollMapper());
     List<Map<String,Object>>request=new ArrayList<>();
     for(CourseEnroll listOfPayments:paymentDetails) {
        Map<String,Object>payment=new HashMap<>();
        payment.put("learnerId",listOfPayments.getLearnerId()); 
        payment.put("categoryId",listOfPayments.getCategoryId()); 
        payment.put("instructorId", listOfPayments.getInstructorId());
        payment.put("courseName",listOfPayments.getCourseName());
        payment.put("paymentType", listOfPayments.getPaymentType());
        payment.put("paymentDetail", listOfPayments.getPaymentDetail());
        payment.put("enroll", listOfPayments.getEnroll());       
        payment.put("amount", listOfPayments.getAmount());
        request.add(payment);
    }
 model.addAttribute("Payments",request);
 return paymentDetails;
 }

public List<CourseSelect> dynamicCategoryCode(Model model) {
    String query = "select CategoryId from showcategories ";
    List<CourseSelect> dynamicList = jdbc.query(query, new CategoryMapper());
    List<Integer> categoryId = new ArrayList<>();
    for (CourseSelect pList : dynamicList) {
    	categoryId.add(pList.getCategoryId()); 
    	
    }
    model.addAttribute("CategoryId", categoryId);
    return dynamicList;

}
public List<CourseSelect>listOfCourseDetails(Model model){
	String listOfCourse="Select categoryid,coursename,durationofcourse,moduels from courselist";
	
	 List<CourseSelect>courseList = jdbc.query(listOfCourse,new CourseSelectedMapper());
     List<Map<String,Object>>request=new ArrayList<>();
     for(CourseSelect courses:courseList) {
        Map<String,Object>course=new HashMap<>();
     
        course.put("categoryId",courses.getCategoryId()); 
        course.put("courseName",courses.getCourseName());
        course.put("durationofcourse", courses.getDurationOfCourse());
        course.put("moduels",courses.getModules());
     
        request.add(course);
    }
 model.addAttribute("CourseList",request);
 
 return courseList;
 }

}
