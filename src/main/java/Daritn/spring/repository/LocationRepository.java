package Daritn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Daritn.spring.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
