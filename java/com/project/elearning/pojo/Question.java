package com.project.elearning.pojo;

public class Question {
private String questionText;
private String options;
public String getQuestionText() {
	return questionText;
}
public void setQuestionText(String questionText) {
	this.questionText = questionText;
}
public String getOptions() {
	return options;
}
public void setOptions(String options) {
	this.options = options;
}
@Override
public String toString() {
	return "Question [questionText=" + questionText + ", options=" + options + "]";
}
public Question() {
	super();

}
}
