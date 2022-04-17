package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Annonce;
import Daritn.spring.repository.AnnonceRepository;

@Service
public class AnnonceServiceImpl implements AnnonceService{

	@Autowired
	private AnnonceRepository AnnonceRepository ;
	
	
	@Override
	public Annonce saveAnnonce(Annonce a) {
		return AnnonceRepository.save(a);
	}

	@Override
	public Annonce updateAnnonce(Annonce a) {
		return AnnonceRepository.save(a);
	}

	@Override
	public void deleteAnnonce(Annonce a) {
		
		AnnonceRepository.delete(a);
	}

	@Override
	public void deleteAnnonceById(Long id) {
		AnnonceRepository.deleteById(id);
		
	}

	@Override
	public Annonce getAnnonce(Long id) {
		return AnnonceRepository.findById(id).get();
	}

	@Override
	public List<Annonce> getAllAnnonces() {
		return AnnonceRepository.findAll();
	}

}
