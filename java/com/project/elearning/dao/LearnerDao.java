package com.project.elearning.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.elearning.connection.ConnectionUtil;
import com.project.elearning.exception.MailIdException;
import com.project.elearning.interfcae.LearnerDaoInterface;
import com.project.elearning.mapper.AdminCourseMapper;
import com.project.elearning.mapper.AmountMapper;
import com.project.elearning.mapper.CourseEnrollMapper;
import com.project.elearning.mapper.CourseMapper;
import com.project.elearning.mapper.CourseSelectMapper;
import com.project.elearning.mapper.DynamicCourseMapper;
import com.project.elearning.mapper.FeedbackMapper;
import com.project.elearning.mapper.LearnerIdMapper;
import com.project.elearning.mapper.LearnerListMapper;
import com.project.elearning.mapper.LearnerMapper;
import com.project.elearning.mapper.MailIdMapper;
import com.project.elearning.mapper.MarksMapper;
import com.project.elearning.mapper.QuestionMapper;
import com.project.elearning.mapper.RegisterMapper;
import com.project.elearning.mapper.SelectCourseMapper;
import com.project.elearning.mapper.TestMapper;
import com.project.elearning.mapper.VideoMapper;
import com.project.elearning.pojo.AdminCourse;
import com.project.elearning.pojo.CourseEnroll;
import com.project.elearning.pojo.CourseSelect;
import com.project.elearning.pojo.Feedback;
import com.project.elearning.pojo.Instructors;
import com.project.elearning.pojo.Learner;
import com.project.elearning.pojo.Mark;
import com.project.elearning.pojo.Test;
import com.project.elearning.pojo.Video;
import com.project.elearning.service.LearnerService;


public class LearnerDao implements LearnerDaoInterface {

	JdbcTemplate jdbc = ConnectionUtil.getJdbcTemplate();
	
	String hello = "categoryCode";
	String codeOfInstructor="InsId";
   String idOfLearner="learnerId";
   String nameOfTheCourse="JAVA";
	
		public void insertLearnerDetails(Learner learn,HttpSession session) {
			String insert = "insert into Learners(learnerName ,learnerMailId ,learnerPassword ,learnerId)values(?,?,?,?)";
			Object[] register = { learn.getLearnerName(), learn.getLearnerMailId(), learn.getLearnerPassword(),
			giveLearnerId(learn.getLearnerId())};
			session.setAttribute("learnersName",learn.getLearnerName());
			jdbc.update(insert, register);
			String selectLearnerId="select learnerId from Learners where learnerMailId=?";
			 List<Learner>leanersList = jdbc.query(selectLearnerId,new LearnerIdMapper(), learn.getLearnerMailId());
		     List<Map<String,Object>>request=new ArrayList<>();
		     for(Learner learners:leanersList) {
		        Map<String,Object>learner=new HashMap<>();
		        learner.put("learnerMailId",learners.getLearnerId()); 
		 Integer  learnersMail = learners.getLearnerId();
		     session.setAttribute("learnId", learnersMail);
		     
		        request.add(learner);
		       
		    }
		
		 } 
		
		public int giveLearnerId(Integer integer) {
			return ThreadLocalRandom.current().nextInt(0,10000);

		}
	public void updateLearner(Learner learn) {
		String update = "update Learners set learnerPassword =? where learnerId=?";
		Object[] updateData = { learn.getLearnerPassword(), learn.getLearnerId() };
		 jdbc.update(update, updateData);
	}
	public void removeLearner(Learner learn) {
		String updates = "Delete from Learners where learnerId=? ";
		Object[] deletedata= {learn.getLearnerId()};
		jdbc.update(updates, deletedata);
	}
public boolean checkMail(Learner learn,Model model) {
	String email=learn.getLearnerMailId();
	boolean status=false;
    String query="select learnerMailId from Learners where learnerMailId=?";
    List<Learner> list=jdbc.query(query,new MailIdMapper(),email);
     for (Learner learning : list) {
            String mailId=learning.getLearnerMailId();
            if(!mailId.equals(email)) {
              return true;   
            }
            else
            {
            	String errorMessage="MailId Already Exist";
            	model.addAttribute("errorMessage8", errorMessage);
            	return false;
            }
        }
     return status;
}

public Boolean learnerLogin(Learner learn,HttpSession session ) {
	
	int learnerId=learn.getLearnerId();
	String learnerName=learn.getLearnerName();
	String learnerPassword=learn.getLearnerPassword();
	
		String login="Select learnerId,learnerName,learnerPassword from Learners where learnerId=?";
		List<Learner>logins=jdbc.query(login, new LearnerMapper(), learnerId);
		for(Learner learning:logins) {
			if(learning!=null) {
				int id=learning.getLearnerId();
			session.setAttribute("learnId",learn.getLearnerId());
				if(id==learnerId) {
				String names=learning.getLearnerName();
				if(names.equals(learnerName)) {
					String password=learning.getLearnerPassword();
					if(password.equals(learnerPassword)) {
						
						String name=learning.getLearnerName();
						session.setAttribute("learnersName",name);
						session.setAttribute(idOfLearner,learn.getLearnerId());
						return true;
						
					}	
			}
				}
			}	
			else {
				
				return false;
			
			}
		}
		return false;
		
	}


public List<Mark> getPercentage(HttpSession session,Model model){
	Integer learnerId= (Integer) session.getAttribute(idOfLearner);
	String query="Select percentage from Results where learnerId=?";
	
	
	 List<Mark>leanersList = jdbc.query(query,new MarksMapper(),learnerId);
     List<Map<String,Object>>request=new ArrayList<>();
     for(Mark certificate:leanersList) {
        Map<String,Object>learner=new HashMap<>();
        learner.put("percentage",certificate.getPercentage()); 
     Float percent = certificate.getPercentage();
     session.setAttribute("percentage", percent);
        request.add(learner);
       
    }
 model.addAttribute("Certify",request);
 return leanersList;
 } 
public List<CourseEnroll> getLearnerDetails(HttpSession session,Model model){
	Integer learnerId= (Integer) session.getAttribute(idOfLearner);
	String paymentList="select learnerId,categoryId,instructorId,courseName,paymentType,paymentDetail,enroll,amount from PaymentDetails where learnerId=?";
	
	 List<CourseEnroll>payment = jdbc.query(paymentList,new CourseEnrollMapper(),learnerId);
    List<Map<String,Object>>request=new ArrayList<>();
    for(CourseEnroll profile:payment) {
       Map<String,Object>paymentDetails=new HashMap<>();
       paymentDetails.put("learnersId",profile.getLearnerId()); 
       paymentDetails.put("categoryId",profile.getCategoryId()); 
       paymentDetails.put("instructorsId", profile.getInstructorId());
       Integer instructId= profile.getInstructorId();
       session.setAttribute("codeOfInstructor", instructId);
       paymentDetails.put("coursesName",profile.getCourseName());
       
       String name= profile.getCourseName();
       session.setAttribute("JAVA", name);
       paymentDetails.put("paymentType", profile.getPaymentType());
       paymentDetails.put("paymentDetail", profile.getPaymentDetail());
       paymentDetails.put("enroll", profile.getEnroll()); 
       Date date=profile.getEnroll();
       session.setAttribute("Date", date);
       
       paymentDetails.put("amount", profile.getAmount());
       request.add(paymentDetails);
   }
model.addAttribute("Payments",request);
return payment;
}


public List<AdminCourse> searchCourse(HttpSession session) {
	AdminCourse course=new AdminCourse();
	String categoryName = null;
	String search="select categoryId,amount,descriptions from showcategory where categoryName=?";
	session.setAttribute("payment",course.getAmount());
	return jdbc.query(search,new AdminCourseMapper(),categoryName);
	
	
}

public List<Learner> viewUserList(Model model){
	String list="select learnerId,learnerName,learnerMailId,learnerPassword from Learners";
	
	 List<Learner>leanersList = jdbc.query(list,new LearnerListMapper());
       List<Map<String,Object>>request=new ArrayList<>();
       for(Learner listOfVideos:leanersList) {
          Map<String,Object>learner=new HashMap<>();
          learner.put("learnerId",listOfVideos.getLearnerId()); 
          learner.put("learnerName",listOfVideos.getLearnerName()); 
          learner.put("learnerMailId",listOfVideos.getLearnerMailId()); 
          learner.put("learnerPassword",listOfVideos.getLearnerPassword()); 
          request.add(learner);
      }
   model.addAttribute("learners",request);
   return leanersList;
   } 


public List<CourseSelect> viewSelectedCourse(Integer categoryId,HttpSession session,Model model){
	
	
	
	
	String list1="Select categoryId,courseName,ratingOfCourse,durationOfCourse,moduels from CourseList where categoryId=? ";
	List<CourseSelect> selectList=jdbc.query(list1, new CourseSelectMapper(), categoryId);
 
	session.setAttribute("categoryId",categoryId);


     List<Map<String,Object>>request=new ArrayList<>();
     for(CourseSelect listOfCourse:selectList) {
        Map<String,Object>learner=new HashMap<>();
        learner.put("categoryId",listOfCourse.getCategoryId()); 
        learner.put("courseName",listOfCourse.getCourseName()); 
        learner.put("ratingOfCourse",listOfCourse.getRatingOfCourse()); 
        learner.put("durationOfCourse",listOfCourse.getDurationOfCourse()); 
        learner.put("moduels",listOfCourse.getModules()); 
        request.add(learner);
    }
 model.addAttribute("Courses",request);
 return selectList;
 } 
	

public List<Instructors> courseDetails(Instructors instruct,Model model) throws JsonProcessingException{
	Integer categoriesId=instruct.getCategoriesId();
	String listCourse="Select categoriesId,instructorId,instructorName,experience,ratingOfInstructor,durationOfCourse,instructorCode from Instructors where categoriesId=?";

 List<Instructors> selectList=jdbc.query(listCourse,new SelectCourseMapper(),categoriesId );


 List<Map<String,Object>>instructor=new ArrayList<>();
 for(Instructors listOfInstructors:selectList) {
    Map<String,Object>learner=new HashMap<>();
    learner.put("categoriesId",listOfInstructors.getCategoriesId()); 
    learner.put("instructorId",listOfInstructors.getInstructorId()); 
    learner.put("instructorName",listOfInstructors.getInstructorName());
    learner.put("experience",listOfInstructors.getExperience()); 
    learner.put("ratingOfInstructor",listOfInstructors.getRatingOfInstructor()); 
    learner.put("durationOfCourse",listOfInstructors.getDurationOfCourse()); 
    learner.put("instructorCode",listOfInstructors.getInstructorCode()); 
    instructor.add(learner);
}
 ObjectMapper instructors=new ObjectMapper();
 String instructorsList=instructors.writeValueAsString(instructor);
model.addAttribute("CourseDetail",instructorsList);
return selectList;
} 


public int givePaymentId() {
	return ThreadLocalRandom.current().nextInt();
	
}
public List<CourseSelect>searchCourseName(CourseSelect courses){
	String courseName=courses.getCourseName();
	String searchCourse="select categoryId,courseName,ratingofcourse,durationofcourse,moduels from CourseList where CourseName like ?";
	return jdbc.query(searchCourse,new CourseSelectMapper(),courseName);
	
}

public List <AdminCourse>getAmount(HttpSession session,Model model){
	Integer categoryId=(Integer) session.getAttribute("categoryId");
	String getAmount="select Amount from showCategories where categoryId=?";
	List<AdminCourse> selectList= jdbc.query(getAmount,new AmountMapper(), categoryId);
	 List<Map<String,Object>>amount=new ArrayList<>();
	 for(AdminCourse takeAmount:selectList) {
	    Map<String,Object>learner=new HashMap<>();
	    learner.put("Amount",takeAmount.getAmount()); 
	    Integer amount1=takeAmount.getAmount();
		session.setAttribute("amount", amount1);
	    amount.add(learner);
	}
	model.addAttribute("CourseDetail",amount);
	return selectList;
	}


public List <CourseSelect>getCourseNameDynamic(HttpSession session,Model model){
	Integer categoryId=(Integer) session.getAttribute("categoryId");
	String getCourseName="select courseName from CourseList where categoryId=?";
	List<CourseSelect> dynamicCourseName=jdbc.query(getCourseName, new DynamicCourseMapper() , categoryId);
	 List<String>courseName=new ArrayList<>();
	 for(CourseSelect getCourse:dynamicCourseName) {
		 
		 courseName.add(getCourse.getCourseName());
	}
	 model.addAttribute("DynamicCourseName", courseName);
	return dynamicCourseName;

}

public void insertCoursePayment(CourseEnroll course,HttpSession session){
	
	String inserts="insert into PaymentDetails (learnerId,categoryId,instructorId,courseName,paymentType,paymentDetail,paymentId,paymentStatus,amount,enroll) values(?,?,?,?,?,?,?,?,?,LocalTimestamp)";
	Object[] params= {course.getLearnerId(),course.getCategoryId(),course.getInstructorId(),course.getCourseName(),course.getPaymentType(),course.getPaymentDetail(),course.getPaymentId(),course.getPaymentStatus(),course.getAmount()};
	jdbc.update(inserts, params);
	
	
	 String courseName=course.getCourseName(); 
	session.setAttribute("JAVA", courseName);
	
	Integer instructorId=course.getInstructorId();
	session.setAttribute("codeOfInstructor", instructorId);
		
		
	}



public void insertCoursePayment1(CourseEnroll course,HttpSession session){
	
	String insert1="insert into PaymentDetails (learnerId,categoryId,instructorId,courseName,paymentType,paymentDetail,paymentId,paymentStatus,amount,enroll) values(?,?,?,?,?,?,?,?,?,LocalTimestamp)";
	Object[] params= {course.getLearnerId(),course.getCategoryId(),course.getInstructorId(),course.getCourseName(),course.getPaymentType(),course.getPaymentDetail(),course.getPaymentId(),course.getPaymentStatus(),course.getAmount()};
	jdbc.update(insert1, params);
	
	
	String courseName=course.getCourseName(); 
	session.setAttribute("JAVA", courseName);
	
	Integer instructorId=course.getInstructorId();
	session.setAttribute("codeOfInstructor", instructorId);
		
		
	}

public List<Video> getCourseVideos(HttpSession session,Model model) {
	
String courseName =(String) session.getAttribute("JAVA");
Integer instructorId=(Integer) session.getAttribute("codeOfInstructor");

  
	
		String query1="select video,descriptionOfVideo from AddVideos where instructorId=? and courseName=?";
		 

		List<Video> selectList=  jdbc.query(query1,new VideoMapper(),instructorId,courseName);


		 List<Map<String,Object>>video=new ArrayList<>();
		 for(Video takeVideo:selectList) {
		    Map<String,Object>videos=new HashMap<>();
		    videos.put("video",takeVideo.getVideos()); 
		    videos.put("descriptionOfVideo",takeVideo.getDescriptionOfVideo());

		    
		    video.add(videos);
		}
		model.addAttribute("CourseVideos",video);
		return selectList;
		} 
public List<Video> getEnrolledVideos(HttpSession session,Model model) {
	
	String courseName =(String) session.getAttribute("JAVA");
	Integer instructorId=(Integer) session.getAttribute("codeOfInstructor");
	
	
	
	String enrolled="select video,descriptionOfVideo from AddVideos where instructorId=? and courseName=?";
	
	
	List<Video> selectList=  jdbc.query(enrolled,new VideoMapper(),instructorId,courseName);
	
	
	List<Map<String,Object>>video=new ArrayList<>();
	for(Video takeVideo:selectList) {
		Map<String,Object>videos=new HashMap<>();
		videos.put("video",takeVideo.getVideos()); 
		videos.put("descriptionOfVideo",takeVideo.getDescriptionOfVideo());
		
		
		video.add(videos);
	}
	model.addAttribute("CourseVideos",video);
	return selectList;
} 

public void insertMarks(Mark mark) {
	
	String insertMarks="insert into Results (learnerId,instructorId,score,percentage) values (?,?,?,?)";
	Object[] insert= {mark.getLearnerId(),mark.getInstructorId(),mark.getScore(),mark.getPercentage()};
	
	jdbc.update(insertMarks, insert);	
}

public void insertReview(Feedback feedback) {
	String insertReviews="insert into Reviews (learnerName,learnerId,instructorId,review,ratingOfInstructor)values(?,?,?,?,?)";
	Object[] review= {feedback.getLearnerName(),feedback.getLearnerId(),feedback.getInstructorId(),feedback.getReview(),feedback.getRatings()};
	jdbc.update(insertReviews, review);	
}
public List<Feedback> getFeedbacks(Model model){
	String getFeedback="select learnerName,review,ratings from FeedbackForm";
	
	
	List<Feedback> feedbackList=  jdbc.query(getFeedback,new FeedbackMapper());


	 List<Map<String,Object>>review=new ArrayList<>();
	 for(Feedback takeFeedback:feedbackList) {
	    Map<String,Object>feedback=new HashMap<>();
	    feedback.put("learnerName",takeFeedback.getLearnerName()); 
	    feedback.put("review",takeFeedback.getReview());
	    feedback.put("ratings",takeFeedback.getRatings());
	    

	    
	    review.add(feedback);
	  
	}
	model.addAttribute("Feedback",review);
	return feedbackList;
	} 




	 public List<Test>testQuestions(HttpSession session,Model model)
{
		 String courseName =(String)session.getAttribute("JAVA");
	
		 Integer instructorId=(Integer) session.getAttribute("codeOfInstructor");
		
		String listTestQuestions="Select instructorid,coursename,questionno,question,option1,option2,option3,correctanswer from MCQ where instructorid=? and courseName=? ";

	     List<Test>listOfTestQuestions =jdbc.query(listTestQuestions,new QuestionMapper(),instructorId,courseName);
	      
	     List<Map<String,Object>>request=new ArrayList<>();
	        for(Test question:listOfTestQuestions) {
	           Map<String,Object>questionTest=new HashMap<>();
	           questionTest.put("instructorId",question.getInstructorId()); 
	         
	           questionTest.put("courseName", question.getCourseName());
	         
	           questionTest.put("questionNo", question.getQuestionNo());
	           questionTest.put("question",question.getQuestion());
	           questionTest.put("option1",question.getOption1());
	           questionTest.put("option2",question.getOption2());
	           questionTest.put("option3",question.getOption3());
	           questionTest.put("correctAnswer",question.getCorrectAnswer());
	           
	           request.add(questionTest);
	          
	       }
	        List<Map<String,Object>> requests=request.stream().toList();
	    model.addAttribute("Question",requests);
	    return listOfTestQuestions;
	    }
	
	 public List<Test>testMcqQuestions(HttpSession session,Model model)
	 {
		 String courseName =(String) session.getAttribute("JAVA");
			Integer instructorId=(Integer) session.getAttribute("codeOfInstructor");
		 String mcqQuestions="Select instructorid,coursename,questionno,question,option1,option2,option3,correctanswer from MCQ where instructorid=? and courseName=? ";
		 
		 List<Test>listOfMcqQuestions =jdbc.query(mcqQuestions,new QuestionMapper(),instructorId,courseName);
		 
		 List<Map<String,Object>>request=new ArrayList<>();
		 for(Test question:listOfMcqQuestions) {
			 Map<String,Object>mcqTest=new HashMap<>();
			 mcqTest.put("instructorId",question.getInstructorId()); 
			 
			 mcqTest.put("courseName", question.getCourseName());
			 
			 mcqTest.put("questionNo", question.getQuestionNo());
			 mcqTest.put("question",question.getQuestion());
			 mcqTest.put("option1",question.getOption1());
			 mcqTest.put("option2",question.getOption2());
			 mcqTest.put("option3",question.getOption3());
			 mcqTest.put("correctAnswer",question.getCorrectAnswer());
			 
			 request.add(mcqTest);
			 
		 }
		 List<Map<String,Object>> requests=request.stream().toList();
		 model.addAttribute("Question",requests);
		 return listOfMcqQuestions;
	 }
	 
	 
	
}
 