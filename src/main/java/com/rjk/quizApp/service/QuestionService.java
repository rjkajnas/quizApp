package com.rjk.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rjk.quizApp.model.Question;
import com.rjk.quizApp.repo.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository repo;

	public ResponseEntity<List<Question>> getAllQuestions() {
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.OK);
	}
	
	public ResponseEntity<Question> addQuestion(Question qn) {
		return new ResponseEntity<>(repo.save(qn), HttpStatus.CREATED);
	}
	
	
}
