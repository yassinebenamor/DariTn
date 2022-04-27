package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Quiz;
import Daritn.spring.repository.QuizRepository;

@Service
public class QuizService implements IQuizService{

	@Autowired
	QuizRepository QuizRepo;
	
	

	@Override
	public Quiz addQuiz(Quiz c) {
		return QuizRepo.save(c);
	}

	@Override
	public void deleteQuiz(int idR) {
		QuizRepo.deleteById(idR);
	}


	@Override
	public List<Quiz> retrieveAllQuiz() {
		return (List<Quiz>)QuizRepo.findAll();
	}

	@Override
	public Quiz updateidQuiz(Quiz c) {
		return QuizRepo.save(c);
	}

	@Override
	public Quiz retrieveidQuiz(int idQ) {
		return QuizRepo.findById(idQ).orElse(null);
	}
	

}
