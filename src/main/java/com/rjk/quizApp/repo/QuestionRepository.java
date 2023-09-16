package com.rjk.quizApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rjk.quizApp.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	public List<Question> findByCategory(String category);
	@Query(value="select * from question q where q.category = :category order by RANDOM() limit :numQ", nativeQuery=true)
	public List<Question> findQuestionsByCategory(String category, int numQ);

}
