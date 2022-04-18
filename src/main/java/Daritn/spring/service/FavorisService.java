package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Annonce;
import Daritn.spring.entity.Favoris;
import Daritn.spring.repository.FavorisRepository;

@Service
public class FavorisService {
	@Autowired
	private FavorisRepository favorisRepository;
	public Favoris saveFavoris(Favoris a) {
		return favorisRepository.save(a);
	}
public void deleteFavoris(Favoris a) {
		
	favorisRepository.delete(a);
	}

public List<Favoris> getAllFavoris() {
	return favorisRepository.findAll();
}

}
