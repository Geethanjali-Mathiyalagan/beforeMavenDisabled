package com.project.elearning.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.elearning.connection.ConnectionUtil;
import com.project.elearning.interfcae.InstructorDaoInterface;
import com.project.elearning.mapper.CourseEnrollMapper;
import com.project.elearning.mapper.CourseMapper;
import com.project.elearning.mapper.EnrollMapper;
import com.project.elearning.mapper.InstructorList;
import com.project.elearning.mapper.InstructorLoginMapper;
import com.project.elearning.mapper.InstructorMapper;
import com.project.elearning.mapper.MarkMapper;
import com.project.elearning.mapper.QuestionMapper;
import com.project.elearning.mapper.VideoMapper;
import com.project.elearning.pojo.CourseEnroll;

import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Instructor;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Test;
import com.project.elearning.pojo.Video;

public class InstructorDao implements InstructorDaoInterface {
	
	JdbcTemplate jdbc = ConnectionUtil.getJdbcTemplate();
	@Autowired
	HttpSession session;
	
	
	
	
	public void videoInserting(Video video) {
	     
			String java="insert into AddVideos(instructorId,courseName,video,descriptionOfVideo)values(?,?,?,?)";
			Object[] params= {video.getInstructorId(),video.getCourseName(),video.getVideos(),video.getDescriptionOfVideo()};
			jdbc.update(java, params);
	
		
	}
	
	
	
	public int updateVideo(Instructor instructor) {
		String updateVideo="update AddVideos set video=? where videoDetails=?";
		Object[] params1= {instructor.getVideo(),instructor.getVideoDetails()};
		return jdbc.update(updateVideo, params1);
		
		
	}
	
	public void deleteVideo(Instructor instructor) {
		String deleteVideo="delete from AddVideos where videoDetails=?";
		Object[] params2= {instructor.getVideoDetails()};
		jdbc.update(deleteVideo, params2);
		
	}
	
	
	public Boolean instructorLogin(Instructors instruct, HttpSession session) {
		
		Integer instructorId = instruct.getInstructorId();
		
		String instructorPassword = instruct.getInstructorPassword();
		
		
			String loginInstructor = "Select instructorId,instructorPassword from Instructors where instructorId=?";
			List<Instructors> login = jdbc.query(loginInstructor, new InstructorLoginMapper(), instructorId);
			for (Instructors instructor : login) {
				if (instructor != null) {
					Integer id = instructor.getInstructorId();
					session.setAttribute("ID",id);
				

					if (Objects.equals(id, instructorId)) {
						String password = instructor.getInstructorPassword();
						
						if (password.equals(instructorPassword)) {

							
							Integer id1 = instructor.getInstructorId();
							session.setAttribute("instructorPassword", id1);
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

	
	
	
	public void insertQuestions(Test test) {
		
		String insertQuestions="insert into MCQ (instructorid,coursename,question,option1,option2,option3,correctAnswer) values (?,?,?,?,?,?,?)";
		Object[] question= {test.getInstructorId(),test.getCourseName(),test.getQuestion(),test.getOption1(),test.getOption2(),test.getOption3(),test.getCorrectAnswer()};
		
		jdbc.update(insertQuestions, question);
		
	}
	
	public Integer updateQuestions(Test test) {
		String updateQuestions="update MCQ set question=? ,option1=?, option2=?,option3=? where questionNo=?";
		Object[] question2= {test.getQuestion(),test.getOption1(),test.getOption2(),test.getOption3(),test.getQuestionNo()};
		return jdbc.update(updateQuestions, question2);
		
	}
	
	public Integer removeQuestions(Test test) {
		String removeQuestions="Delete from MCQ where questionNo=?";
		Object[] question3= {test.getQuestionNo()};
		return jdbc.update(removeQuestions, question3);
		
		
	}
	public List<String> dynamicCourseName() {
	    
	  
        String query = "select coursename from courselist ";
        List<CourseEnroll> partList = jdbc.query(query, new CourseMapper());
        List<String> courseName = new ArrayList<>();
        for (CourseEnroll pList : partList) {
        	courseName.add(pList.getCourseName());
        }
        return courseName;

    }
	
	
	
	
	
	
	
	
	
	
	 public List<Test>listOfQuestions(HttpSession session,Model model)
{
		 
		 Integer instructorId=(Integer) session.getAttribute("ID");
		
		String listQuestions1="Select instructorid,coursename,questionno,question,option1,option2,option3,correctanswer from MCQ where instructorid=? ";

	     List<Test>listOfQuestions =jdbc.query(listQuestions1,new QuestionMapper(),instructorId);
	      
	     List<Map<String,Object>>request=new ArrayList<>();
	        for(Test question:listOfQuestions) {
	           Map<String,Object>questionMap=new HashMap<>();
	           questionMap.put("instructorId",question.getInstructorId()); 
	         
	           questionMap.put("courseName", question.getCourseName());
	         
	           questionMap.put("questionNo", question.getQuestionNo());
	           questionMap.put("question",question.getQuestion());
	           questionMap.put("option1",question.getOption1());
	           questionMap.put("option2",question.getOption2());
	           questionMap.put("option3",question.getOption3());
	           questionMap.put("correctAnswer",question.getCorrectAnswer());
	           
	           request.add(questionMap);
	       }
	    model.addAttribute("Question",request);
	    return listOfQuestions;
	    }
	     
	 
	 
	
	     
	
	 
	 public List<Video>listOfVideo(HttpSession session,Model model){
		 Integer instructorId=(Integer) session.getAttribute("ID");
		
			 String getVideos="select video,descriptionOfVideo from AddVideos where instructorId=?";
			
			 List<Video>videoList =jdbc.query(getVideos, new VideoMapper(),instructorId);
		        List<Map<String,Object>>request=new ArrayList<>();
		        for(Video listOfVideos:videoList) {
		           Map<String,Object>videoMap=new HashMap<>();
		           videoMap.put("video",listOfVideos.getVideos());
		           videoMap.put("descriptionOfVideo",listOfVideos.getDescriptionOfVideo());
		           request.add(videoMap);
		       }
		    model.addAttribute("videos",request);
		    return videoList;
		    } 
		
		 
	 
	  	 
	 public List<Mark>listOfLearners(HttpSession session,Model model) throws JsonProcessingException{
		 Integer instructorId=(Integer) session.getAttribute("ID");
		
		
			 String videos="select learnerId,Score,percentage from Results where instructorId=?";
			 List<Mark>learnerList =jdbc.query(videos, new MarkMapper(),instructorId);
		        List<Map<String,Object>>request=new ArrayList<>();
		        for(Mark listOfLearners:learnerList) {
		           Map<String,Object>markMap=new HashMap<>();
		           markMap.put("learnerId",listOfLearners.getLearnerId()); 
		           markMap.put("score", listOfLearners.getScore());
		         
		           markMap.put("percentage",listOfLearners.getPercentage());
		           
		           request.add(markMap);
		       }
		        ObjectMapper learnersList=new ObjectMapper();
		        String instructorsList=learnersList.writeValueAsString(request);
		    model.addAttribute("ViewRequest",instructorsList);
		    return learnerList;
		    } 
	 
	 
	 public int updateLearnersList(Mark markpojo) {
			String updateVideo="update Results set grade=?,percentage=?  where learnerId=?";
			Object[] updateLearner= {markpojo.getGrade(),markpojo.getPercentage(),markpojo.getLearnerId()};
			return jdbc.update(updateVideo, updateLearner);
		
		}
	 
	 public List<Mark>learnersList(Model model){
		 String listLearners="select learnerId,Score,percentage from Results";
		
		 List<Mark>learnerList =jdbc.query(listLearners,new MarkMapper());
	        List<Map<String,Object>>request=new ArrayList<>();
	        for(Mark listOfLearners:learnerList) {
	           Map<String,Object>markMap=new HashMap<>();
	           markMap.put("learnerId",listOfLearners.getLearnerId()); 
	           markMap.put("score", listOfLearners.getScore());
	           markMap.put("percentage",listOfLearners.getPercentage());
	           
	           request.add(markMap);
	       }
	    model.addAttribute("ViewRequest",request);
	    return learnerList;
	    } 
	 public Integer particularInstructorLearnerCount(Integer id) {
			String count="select count(instructorid) from PaymentDetails where instructorid=?";
			return jdbc.queryForObject(count,Integer.class,id);
	
		}
	 public Integer testLearnersCount(Integer id) {
		 String countLearn="select count(instructorid) from Results where instructorid=?";
		 return jdbc.queryForObject(countLearn,Integer.class,id);
	 }

	 
}

