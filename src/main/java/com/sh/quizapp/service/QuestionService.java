package com.sh.quizapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.quizapp.DAO.QuestionDao;
import com.sh.quizapp.model.Questions;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Questions> getAllQuestions() {
		List<Questions> list = questionDao.findAll();
		for (Questions question : list) {
            System.out.println(question);  // This will call the overridden toString() method
        }
		return questionDao.findAll();
	}
	
	

}
