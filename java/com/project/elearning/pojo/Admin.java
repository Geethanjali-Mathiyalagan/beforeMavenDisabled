package com.project.elearning.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Admin {
private Integer adminId;
private String adminRole;
private String adminPassword;
private Long accountNumber;
private Long phoneNumber;
public Integer getAdminId() {
	return adminId;
}
public Admin() {
	super();
	
}
@Override
public String toString() {
	return "AdminLogin [adminId=" + adminId + ", adminRole=" + adminRole + ", adminPassword=" + adminPassword
			+ ", accountNumber=" + accountNumber + ", phoneNumber=" + phoneNumber + "]";
}
public void setAdminId(Integer adminId) {
	this.adminId = adminId;
}
public String getAdminRole() {
	return adminRole;
}
public void setAdminRole(String adminRole) {
	this.adminRole = adminRole;
}
public String getAdminPassword() {
	return adminPassword;
}
public void setAdminPassword(String adminPassword) {
	this.adminPassword = adminPassword;
}
public Long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(Long accountNumber) {
	this.accountNumber = accountNumber;
}
public Long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}

}
