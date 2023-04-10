package com.project.elearning.pojo;

import java.util.Arrays;

import org.springframework.stereotype.Repository;


@Repository
public class Instructor {
	private Integer instructorId;
	private Integer categoryId;
	private String courseName;
	private Integer videoId;
	private String videoDetails;
	private byte[] video;
	private String videoPath;

	@Override
	public String toString() {
		return "InstructorPojo [instructorId=" + instructorId + ", categoryId=" + categoryId + ", courseName="
				+ courseName + ", videoId=" + videoId + ", videoDetails=" + videoDetails + ", video="
				+ Arrays.toString(video) + ", videoPath=" + videoPath + "]";
	}

	public Integer getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getVideoDetails() {
		return videoDetails;
	}

	public void setVideoDetails(String videoDetails) {
		this.videoDetails = videoDetails;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public Instructor() {
		super();
		
	}
	
	



}
