package Daritn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long>  {
	
	@Query(value="SELECT * FROM `rendez_vous` WHERE lieu LIKE %?1% AND etat LIKE %?2% ",nativeQuery =true)
	public List<RendezVous> RechercheMulti(String lieu,String Etat); 
}
