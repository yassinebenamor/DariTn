package Daritn.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import Daritn.spring.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	@Query(value="SELECT SUM(typelocation=?1)/count(*) FROM location ",nativeQuery =true)
	public float Stat(String type); 
	
}
