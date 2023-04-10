package com.project.elearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.elearning.dao.AdminInstructorDao;
import com.project.elearning.pojo.AdminInstructor;

@Service
public class AdminInstructorService {

AdminInstructorDao adminInstructordao=new AdminInstructorDao();
	public void addInstructors(AdminInstructor adminInstruct) {
		adminInstructordao.insertInstructorDetails(adminInstruct);	
	}
	
	
	public void instructorUpdate(AdminInstructor adminInstruct) {
		adminInstructordao.updateInstructorDetails(adminInstruct);
	
	}
}
