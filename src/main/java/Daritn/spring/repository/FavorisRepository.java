package Daritn.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.Annonce;
import Daritn.spring.entity.Favoris;

@Repository
public interface FavorisRepository extends JpaRepository<Favoris, Long>{

}
