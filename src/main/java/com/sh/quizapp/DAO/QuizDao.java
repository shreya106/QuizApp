package com.sh.quizapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sh.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
