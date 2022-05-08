package Daritn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Daritn.spring.entity.Annonce;
import Daritn.spring.entity.Favoris;
import Daritn.spring.repository.AnnonceRepository;
import Daritn.spring.repository.FavorisRepository;

import org.springframework.web.bind.annotation.PathVariable;
import Daritn.spring.service.FavorisService;

@RestController
@CrossOrigin("*")
@RequestMapping("/fav")
public class FavorisController {
	@Autowired
	private FavorisService annonceFavoris ;
	@Autowired
	private AnnonceRepository AnnonceRepository ;
	@Autowired
	private FavorisRepository favorisRepository;
	@PostMapping(value = "/addfavoris/annonce/{idAnnonce}")
	@ResponseBody
	public Favoris Favoris(@RequestBody Favoris a,  @PathVariable Long idAnnonce ) {
		 
		
	        Annonce annonce = AnnonceRepository.findById(idAnnonce).get();
	        a.setAnnonce(annonce);
	        return favorisRepository.save(a);
	}
	@DeleteMapping("/supp-favoris/{Favoris-id}")
	@ResponseBody
	public void removefavoris(@PathVariable("Favoris-id") Long idFavoris ) {
		annonceFavoris.deleteFAvorisById(idFavoris);
	}
	@GetMapping("/getAllFavoris")
	@ResponseBody
	public List<Favoris> getAllFavoris(){
		return annonceFavoris.getAllFavoris();
	}
	  @PutMapping("/{idFavoris}/annonce/{idAnnonce}")
	    Favoris assignAnnonceToFav(
	            @PathVariable Long idFavoris,
	            @PathVariable Long idAnnonce
	    ) {
		  Favoris fav = favorisRepository.findById(idFavoris).get();
	        Annonce annonce = AnnonceRepository.findById(idAnnonce).get();
	        fav.setAnnonce(annonce);
	        return favorisRepository.save(fav);
	    }
}
