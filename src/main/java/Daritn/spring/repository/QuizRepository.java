package Daritn.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.Quiz;



@Repository
public interface QuizRepository  extends CrudRepository< Quiz,Integer> {

}
