package Daritn.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import Daritn.spring.entity.Annonce;
import Daritn.spring.entity.RendezVous;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long>{
	@Query(value="SELECT * FROM `annonce` WHERE lieu LIKE %?1% AND prix = ?2" ,nativeQuery =true)
			public List<Annonce> RechercheMulti(String lieu,double prix); 
	@Query(value="SELECT * FROM `annonce` WHERE lieu LIKE %?1% AND prix LIKE %?2% AND descirption LIKE %?3%",nativeQuery =true)
	public List<Annonce> GetAnnonce(double idAnnonce);
}
