package com.sh.quizapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sh.quizapp.model.Questions;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {

}
