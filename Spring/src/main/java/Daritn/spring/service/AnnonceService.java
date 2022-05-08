package Daritn.spring.service;

import java.util.List;

import Daritn.spring.entity.Annonce;

public interface AnnonceService {
	Annonce saveAnnonce(Annonce a);
	Annonce updateAnnonce(Annonce a);
	void deleteAnnonce(Annonce a);
	void deleteAnnonceById(Long id);
	Annonce getAnnonce(Long id);
	List<Annonce> getAllAnnonces();


}