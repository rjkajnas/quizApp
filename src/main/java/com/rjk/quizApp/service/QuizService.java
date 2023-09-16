package com.rjk.quizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rjk.quizApp.model.Answer;
import com.rjk.quizApp.model.Question;
import com.rjk.quizApp.model.QuestionWrapper;
import com.rjk.quizApp.model.Quiz;
import com.rjk.quizApp.repo.QuestionRepository;
import com.rjk.quizApp.repo.QuizRepository;

@Service
public class QuizService {

	@Autowired
	QuizRepository repo;
	
	@Autowired
	QuestionRepository qrepo;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> questions = qrepo.findQuestionsByCategory(category, numQ);
		Quiz q = new Quiz();
		q.setTitle(title);
		q.setQuestions(questions);
		repo.save(q);
		return new ResponseEntity<>("Quiz creation SUCCESS", HttpStatus.CREATED);

	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz = repo.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForQuiz = new ArrayList<>();
		for (Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionsForQuiz.add(qw);
		}
		return new ResponseEntity<>(questionsForQuiz, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateQuizScore(int id, List<Answer> ans) {
		Quiz quiz = repo.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int score = 0;
		int i = 0;
		for (Answer a : ans) {
			if (a.getAnswer().equals(questions.get(i).getRightAnswer())) {
				score++;
			}
			i++;
		}
		return  new ResponseEntity<>(score, HttpStatus.OK);
	}

}
