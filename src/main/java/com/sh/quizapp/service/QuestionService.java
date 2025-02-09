package com.sh.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sh.quizapp.DAO.QuestionDao;
import com.sh.quizapp.model.Questions;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Questions>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Questions>> findByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Questions question) {
		
		questionDao.save(question);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		}

	public ResponseEntity<String> deleteById(int id) {
		try {
			questionDao.deleteById(id);;
			return new ResponseEntity<>("Success",HttpStatus.OK);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
	}
	
	

}
