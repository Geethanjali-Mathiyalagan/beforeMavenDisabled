package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.elearning.pojo.Admin;

public class AdminLoginMapper implements RowMapper<Admin>{

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
    Admin admin=new Admin();
    Integer adminId=rs.getInt("adminId");
    String adminPassword=rs.getString("adminPassword");

   admin.setAdminId(adminId);
   admin.setAdminPassword(adminPassword);
		return admin;
	}

	
	

}
