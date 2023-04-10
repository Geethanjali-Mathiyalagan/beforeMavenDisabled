package com.project.elearning.pojo;

import java.util.Arrays;

import org.springframework.stereotype.Repository;
@Repository
public class Video {
	private Integer videoNo;
	private Integer instructorId;
	private String courseName;
	private byte[] videos;
	private String videoPath;
	private String descriptionOfVideo;
	public Integer getVideoNo() {
		return videoNo;
	}
	public void setVideoNo(Integer videoNo) {
		this.videoNo = videoNo;
	}
	public Integer getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public byte[] getVideos() {
		return videos;
	}
	public void setVideos(byte[] videos) {
		this.videos = videos;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	@Override
	public String toString() {
		return "Video [videoNo=" + videoNo + ", instructorId=" + instructorId + ", courseName=" + courseName
				+ ", videos=" + Arrays.toString(videos) + ", videoPath=" + videoPath + ", descriptionOfVideo="
				+ descriptionOfVideo + "]";
	}
	public String getDescriptionOfVideo() {
		return descriptionOfVideo;
	}
	public void setDescriptionOfVideo(String descriptionOfVideo) {
		this.descriptionOfVideo = descriptionOfVideo;
	}

	}
