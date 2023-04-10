package com.project.elearning.interfcae;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.elearning.pojo.CourseEnroll;

import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Instructor;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Test;
import com.project.elearning.pojo.Video;

public interface InstructorDaoInterface {
	
	public void videoInserting(Video video);
	public int updateVideo(Instructor instructor);
	public void deleteVideo(Instructor instructor);
	public Boolean instructorLogin(Instructors instruct, HttpSession session) ;
	public void insertQuestions(Test test) ;
	public Integer updateQuestions(Test test);
	public Integer removeQuestions(Test test) ;
	 public List<Test>listOfQuestions(HttpSession session,Model model);
	
	 public List<Video>listOfVideo(HttpSession session,Model model);
	 public List<Mark>listOfLearners(HttpSession session,Model model)throws JsonProcessingException;
	 public int updateLearnersList(Mark markpojo);
	 public List<Mark>learnersList(Model model);
}
