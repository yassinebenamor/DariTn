package Daritn.spring.service;

import java.util.List;

import Daritn.spring.entity.Question;

public interface IQuestionService {
	List<Question> retrieveAllQuestion();
	Question addQuestion(Question c);
	String deleteQuestion(Integer idQ);
	Question updateidQuestion(Question c);
	Question retrieveidQuestion(int idQ);
}
