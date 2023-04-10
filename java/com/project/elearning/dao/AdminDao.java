package com.project.elearning.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.project.elearning.connection.ConnectionUtil;
import com.project.elearning.interfcae.AdminInterface;
import com.project.elearning.mapper.AdminLoginMapper;
import com.project.elearning.mapper.EnrollMapper;
import com.project.elearning.pojo.Admin;
import com.project.elearning.pojo.CourseEnroll;

public class AdminDao implements AdminInterface {

 JdbcTemplate jdbc = ConnectionUtil.getJdbcTemplate();
 Logger logger=LoggerFactory.getLogger(AdminDao.class);
	
 public Boolean adminLogin(Admin admin,HttpSession session) {
		
		Integer adminId=admin.getAdminId();
		String adminPassword=admin.getAdminPassword();
		
		
	
			String adminLogin="select adminId,adminPassword from AdminDetail where adminId=?";
			List<Admin>login=jdbc.query(adminLogin,new AdminLoginMapper(),adminId);
			for(Admin log:login) {
				if(log!=null) {
					int id=log.getAdminId();
					session.setAttribute("ID",admin.getAdminId());
					
					if(id==adminId) {
						String password=log.getAdminPassword();
						
						if(password.equals(adminPassword)) {
							
							Integer id1=log.getAdminId();
							session.setAttribute("adminPassword",id1);
							return true;
						
							
						}
					}
				}
				else {
					
					return false;
					
				}
			}
			return false;
		
	}
	
	
	public Integer totalLearnerCount() {
		String countLearners="Select COUNT(*)from Learners ";
		return jdbc.queryForObject(countLearners, Integer.class);
	}
	public Integer totalInstructorCount() {
		String countInstructors="Select COUNT(*)from Instructors";
		return jdbc.queryForObject(countInstructors, Integer.class);
	}
	
public Integer totalCourses() {
	String countCourses="Select COUNT(*)from Subcategory ";
	return jdbc.queryForObject(countCourses,Integer.class);
}
public Integer totalIncome() {
	String countIncome=" select sum(amount) from paymentDetails";
	return jdbc.queryForObject(countIncome,Integer.class);
} 
public Integer countOfMaximumCourse() {
	String maxCount="SELECT COUNT(COURSENAME)FROM PaymentDetails GROUP BY COURSENAME HAVING COUNT(COURSENAME) =(select max(count(COURSENAME))from PaymentDetails group by COURSENAME)";
	return jdbc.queryForObject(maxCount, Integer.class);
}
public String countOfMaximumCourseName() {
	String maxCountCourseName="SELECT COURSENAME FROM PaymentDetails GROUP BY COURSENAME HAVING COUNT(COURSENAME) =(select max(count(COURSENAME))from PaymentDetails group by COURSENAME)";
	return jdbc.queryForObject(maxCountCourseName,String.class);
}
public Integer countOfMinimumCourse() {
	String maxCount="SELECT COUNT(COURSENAME)FROM PaymentDetails GROUP BY COURSENAME HAVING COUNT(COURSENAME) =(select min(count(COURSENAME))from PaymentDetails group by COURSENAME)";
	return jdbc.queryForObject(maxCount, Integer.class);
}
public String countOfMinimumCourseName() {
	String maxCountCourseName="SELECT COURSENAME FROM PaymentDetails GROUP BY COURSENAME HAVING COUNT(COURSENAME) =(select min(count(COURSENAME))from PaymentDetails group by COURSENAME)";
	return jdbc.queryForObject(maxCountCourseName,String.class);
}



public List<CourseEnroll> listLearners(HttpSession session,Model model)
{
	 
	 Integer instructorId=(Integer) session.getAttribute("ID");
	
    String  learners="select learnerId,categoryId,courseName from PaymentDetails where instructorId=?";
    
    List<CourseEnroll>learnerList =jdbc.query(learners,new EnrollMapper(),instructorId );
       List<Map<String,Object>>request=new ArrayList<>();
       for(CourseEnroll listOfLearners:learnerList) {
          Map<String,Object>requestMap=new HashMap<>();
          requestMap.put("learnerId",listOfLearners.getLearnerId()); 
          requestMap.put("categoryId", listOfLearners.getCategoryId());
          requestMap.put("courseName",listOfLearners.getCourseName());
          
          request.add(requestMap);
      }
   model.addAttribute("ViewRequest",request);
   return learnerList;
   }
}

