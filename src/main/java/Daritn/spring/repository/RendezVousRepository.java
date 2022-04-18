package Daritn.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long>  {
	
	@Query(value="SELECT * FROM `rendez_vous` WHERE lieu LIKE %?1% AND etat LIKE %?2% AND region LIKE %?3%",nativeQuery =true)
	public List<RendezVous> RechercheMulti(String lieu,String Etat,String region); 
	
	@Query(value="SELECT * FROM `rendez_vous` WHERE lieu LIKE %?1% AND etat LIKE %?2% AND region LIKE %?3%",nativeQuery =true)
	public List<RendezVous> GetRdvByUser(int id); 
	
	@Modifying
	@Transactional 
	@Query("update RendezVous rv set rv.etat = ?1 where rv.id = ?2")
	int updateEtat(EnumeratedEtat Etat,Long idrdv); 
	
}
