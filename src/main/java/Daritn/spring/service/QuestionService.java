package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Question;
import Daritn.spring.entity.QuestionsWithReponses;
import Daritn.spring.entity.Reponse;
import Daritn.spring.repository.QuestionRepository;
import Daritn.spring.repository.ReponseRepository;


@Service
public class QuestionService implements IQuestionService {

		@Autowired
		QuestionRepository QuestionRepo;
		@Autowired
		ReponseRepository reponseRepo;
		@Override
		public List<Question> retrieveAllQuestion() {
			List<Question> av = (List<Question>) QuestionRepo.findAll();
			return av;
		}

		@Override
		public Question addQuestion(Question c) {
			return QuestionRepo.save(c); 
		}

		@Override
		public String deleteQuestion(Integer id) {
			if(QuestionRepo.findById(id).orElse(null) != null) {
				QuestionRepo.deleteById(id);
				return "Question removed successfully!";
			}
			else return "Question id not found!";
		}

		@Override
		public Question updateidQuestion(Question c) {
			return QuestionRepo.save(c);
		}

		public List<Object[]> ListerLesReponseByQuestions(){
			return QuestionRepo.NumberReponsesGroupedByQuestions();
		}

		@Override
		public Question retrieveidQuestion(int idR) {
			return QuestionRepo.findById(idR).orElse(null);
			
		}


		public QuestionsWithReponses questionsAndReponses(int idR) {
			Question qs = QuestionRepo.findById(idR).orElse(null);
			List<Reponse> Reponses =   reponseRepo.findByQyestionId(qs);
			QuestionsWithReponses obj = new QuestionsWithReponses();
			obj.setQuestion(qs);
			obj.setReponses(Reponses);
			return obj;
		}
	
}
