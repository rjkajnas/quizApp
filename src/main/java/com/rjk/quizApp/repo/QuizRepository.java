package com.rjk.quizApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rjk.quizApp.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

	
}
