package Daritn.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import Daritn.spring.entity.Achat;
import Daritn.spring.entity.EnumeratedEtat;


public interface AchatRepository extends JpaRepository<Achat, Long> {

	
	@Modifying
	@Transactional 
	@Query("update Achat cl set cl.etat = ?1 where cl.id = ?2")
	int updateEtat(EnumeratedEtat Etat,Long id);
}
