package Daritn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Daritn.spring.entity.Favoris;
import Daritn.spring.service.FavorisService;

@RestController
@CrossOrigin("*")
@RequestMapping("/favoris")
public class FavorisController {
	@Autowired
	private FavorisService annonceFavoris ;
	@PostMapping(value = "/saveFavoris")
	@ResponseBody
	public Favoris Favoris(@RequestBody Favoris a) {
		 
		return annonceFavoris.saveFavoris(a);
	}
	@DeleteMapping("/supp-favoris")
	@ResponseBody
	public void removefavoris(@RequestParam Long idFavoris ) {
		annonceFavoris.deleteFAvorisById(idFavoris);
	}
	@GetMapping("/getAllAnnonces")
	@ResponseBody
	public List<Favoris> getAllFavoris(){
		return annonceFavoris.getAllFavoris();
	}
}
