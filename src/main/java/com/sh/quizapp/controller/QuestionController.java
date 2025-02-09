package com.sh.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.quizapp.model.Questions;
import com.sh.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Questions>> getAllQuestion() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Questions>> findByCategory(@PathVariable String category){
		return questionService.findByCategory(category);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Questions question) {
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
		return questionService.deleteById(id);
	}

}
