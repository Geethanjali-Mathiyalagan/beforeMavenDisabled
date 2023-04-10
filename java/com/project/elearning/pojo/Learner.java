package com.project.elearning.pojo;

public class Learner {

	private String learnerName;
	private String learnerMailId;
	private String learnerPassword;
	private int learnerId;
	@Override
	public String toString() {
		return "Learner [ learnerName=" + learnerName + ", learnerMailId=" + learnerMailId
				+ ", learnerPassword=" + learnerPassword + ", learnerId=" + learnerId + "]";
	}
	public Learner() {
		super();
		
	}
	public Learner( String learnerName, String learnerMailId, String learnerPassword, int learnerId) {
		super();
	
		this.learnerName = learnerName;
		this.learnerMailId = learnerMailId;
		this.learnerPassword = learnerPassword;
		this.learnerId = learnerId;
	}
	
	public String getLearnerName() {
		return learnerName;
	}
	public void setLearnerName(String learnerName) {
		this.learnerName = learnerName;
	}
	public String getLearnerMailId() {
		return learnerMailId;
	}
	public void setLearnerMailId(String learnerMailId) {
		this.learnerMailId = learnerMailId;
	}
	public String getLearnerPassword() {
		return learnerPassword;
	}
	public void setLearnerPassword(String learnerPassword) {
		this.learnerPassword = learnerPassword;
	}
	public int getLearnerId() {
		return learnerId;
	}
	public void setLearnerId(int learnerId) {
		this.learnerId = learnerId;
	}

}
