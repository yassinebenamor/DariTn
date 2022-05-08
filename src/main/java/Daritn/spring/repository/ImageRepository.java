package Daritn.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Daritn.spring.entity.ImageModel;



public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
}