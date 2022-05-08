package Daritn.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.Reclamation;

@Repository
public interface ReclamationRepository  extends CrudRepository<Reclamation,Integer>  {

	@Query("SELECT ve, Count(ve) as nbre FROM Reclamation ve GROUP BY ve.TypeReclamation")
	public List<Object> groupReclamations();
}


