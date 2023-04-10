package com.project.elearning.interfcae;

import com.project.elearning.pojo.AdminInstructor;

public interface AdminInstructorDaoInterface {
	public void insertInstructorDetails(AdminInstructor instruct);
	public String updateInstructorDetails(AdminInstructor instruct);
	public void deleteInstrcutorDetails(AdminInstructor instruct);
}
