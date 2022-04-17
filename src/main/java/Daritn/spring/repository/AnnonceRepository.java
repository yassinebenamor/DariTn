package Daritn.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.Annonce;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long>{

}
