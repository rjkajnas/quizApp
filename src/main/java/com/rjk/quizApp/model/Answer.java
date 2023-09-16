package com.rjk.quizApp.model;

public class Answer {

	private Integer id;
	private String answer;
	
	public Answer(Integer id, String answer) {
		super();
		this.id = id;
		this.answer = answer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
