package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		return AnnonceRepository.findById(id).orElse(null);
	}

	@Override
	public List<Annonce> getAllAnnonces() {
		return AnnonceRepository.findAll(Sort.by("prix").descending());
	}
	
	public List<Annonce> getAllAnnoncesAchat() {
		return AnnonceRepository.GetAnnonceAchat();
	}
	
	public List<Annonce> getAllAnnoncesLocation() {
		return AnnonceRepository.GetAnnonceLocation();
	}
	@Override
	public List<Annonce> getAllAnnoncesByTitre() {
		return AnnonceRepository.findAll(Sort.by("titre").ascending());
	}
	public List<Annonce> getRecherche(String lieu, double prix){
		List<Annonce> Annonce=AnnonceRepository.RechercheMulti(lieu,prix);
		//for (Annonce a: Annonce) {
			//System.out.println("Annonce :" + a);
		//}
		
		return Annonce;
	}
}
