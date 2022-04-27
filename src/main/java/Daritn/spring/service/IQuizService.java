package Daritn.spring.service;

import java.util.List;

import Daritn.spring.entity.Quiz;


public interface IQuizService {
	List<Quiz> retrieveAllQuiz();
	Quiz addQuiz(Quiz c);
	void deleteQuiz(int idQ);
	Quiz updateidQuiz(Quiz c);
	Quiz retrieveidQuiz(int idQ);
	
}
