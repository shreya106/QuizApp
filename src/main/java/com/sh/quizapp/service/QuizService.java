package com.sh.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sh.quizapp.DAO.QuestionDao;
import com.sh.quizapp.DAO.QuizDao;
import com.sh.quizapp.model.Questions;
import com.sh.quizapp.model.QuestionsWrapper;
import com.sh.quizapp.model.Quiz;
import com.sh.quizapp.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Questions> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}


	public ResponseEntity<List<QuestionsWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Questions> questionsFromDB = quiz.get().getQuestions();
		List<QuestionsWrapper> questionsForUser = new ArrayList<>();
		
		for(Questions q: questionsFromDB) {
			QuestionsWrapper qw = new QuestionsWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		
		return new ResponseEntity<List<QuestionsWrapper>>(questionsForUser, HttpStatus.OK);
		
	}


	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Questions> questions = quiz.getQuestions();
		int right = 0;
		int i= 0 ;
		for(Response response: responses) {
			if(response.getResponse().equals(questions.get(i).getAnswer())) {
				right++;
			}
			i++;
			
		}
		return new ResponseEntity<Integer>(right, HttpStatus.OK);
	}
	
	
}
