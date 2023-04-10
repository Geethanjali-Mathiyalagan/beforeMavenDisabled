package com.project.elearning.pojo;

public class Option {
private String text;
private String correct;
public Option() {
	super();
	
}
@Override
public String toString() {
	return "Option [text=" + text + ", correct=" + correct + "]";
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getCorrect() {
	return correct;
}
public void setCorrect(String correct) {
	this.correct = correct;
}


}
