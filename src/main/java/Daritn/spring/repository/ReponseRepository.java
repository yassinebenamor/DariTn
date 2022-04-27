package Daritn.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.Question;
import Daritn.spring.entity.Reponse;


@Repository
public interface ReponseRepository  extends CrudRepository<Reponse,Integer> {
	@Query("SELECT u FROM Reponse u WHERE u.question= :id")
	public List<Reponse> findByQyestionId(@Param("id") Question id);
}
