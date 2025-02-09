package com.sh.quizapp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sh.quizapp.model.Questions;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

	List<Questions> findByCategory(String category);

}
