package com.project.elearning.pojo;

import java.util.Arrays;

import org.springframework.stereotype.Repository;
@Repository
public class AdminCourse {
private Integer categeoryId;
private String categoryName;
private String descriptions;
private Integer amount;
private byte[] image;
private String imagePath;

@Override
public String toString() {
	return "AdminCourse [categeoryId=" + categeoryId + ", categoryName=" + categoryName + ", descriptions="
			+ descriptions + ", amount=" + amount + ", image=" + Arrays.toString(image) + ", imagePath=" + imagePath
			+ "]";
}



public Integer getCategeoryId() {
	return categeoryId;
}



public void setCategeoryId(Integer categeoryId) {
	this.categeoryId = categeoryId;
}



public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public String getDescriptions() {
	return descriptions;
}

public void setDescriptions(String descriptions) {
	this.descriptions = descriptions;
}

public Integer getAmount() {
	return amount;
}

public void setAmount(Integer amount) {
	this.amount = amount;
}

public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}

public String getImagePath() {
	return imagePath;
}

public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}

public AdminCourse() {
	super();
	
}
}
