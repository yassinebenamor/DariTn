package Daritn.spring.repository;

import org.springframework.stereotype.Repository;


import Daritn.spring.entity.ContratLocation;
import Daritn.spring.entity.EnumeratedEtat;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface ContratLocationRepository extends JpaRepository<ContratLocation, Long> , CrudRepository<ContratLocation, Long> {
	
	//SELECT * FROM `contrat_location` cl JOIN `annonce` an join `user` u on u.id_user=cl.locataire_id_user;


@Query(value="SELECT * FROM `contrat_location` cl JOIN `annonce` an join `user` u on u.id_user=cl.locataire_id_user where cl.locataire_id_user=?1",nativeQuery =true)
    public List<ContratLocation> findAllContrat(Long Userid);   

@Query(value="SELECT * FROM `contrat_location` ORDER by ?1",nativeQuery =true)
public List<ContratLocation> SortMulti(String sort); 

@Modifying
@Transactional 
@Query("update ContratLocation cl set cl.etat = ?1 where cl.id = ?2")
int updateEtat(EnumeratedEtat Etat,Long idContrat); 




}
