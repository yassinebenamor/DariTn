package Daritn.spring.controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Daritn.spring.entity.Annonce;
import Daritn.spring.service.AnnonceService;
import Daritn.spring.service.AnnonceServiceImpl;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AnnonceController {
	@Autowired
	private AnnonceServiceImpl annonceService ;
	//localhost:8080/SpringMVC/annonce/saveAnnonce
	
	@PostMapping(value = "/saveAnnonce")
	@ResponseBody
	public Annonce addAnnonce(@RequestBody Annonce annonce) {
		
		 
		return annonceService.saveAnnonce(annonce);
	}

@GetMapping("/getAllAnnonces")
@ResponseBody
public List<Annonce> getAllAnnoncesByTitre(){
	return annonceService.getAllAnnoncesByTitre();
}
@GetMapping("/getAllAnnoncesByPrix")
@ResponseBody
public List<Annonce> getAllAnnoncesByPrix(){
	return annonceService.getAllAnnonces();
}
@DeleteMapping("/suppAnnonce/{Annonce-id}")
@ResponseBody
public void removefavoris(@PathVariable("Annonce-id") Long idAnnonce) {
annonceService.deleteAnnonceById(idAnnonce);
}

@PutMapping("/updateAnnonce")
public Annonce updateAnmnonce(@RequestBody Annonce a) {
	return annonceService.updateAnnonce(a);
}

@GetMapping("/getAnnonce/{Annonce-id}")
	@ResponseBody
	public Annonce GetAnnonce(@PathVariable("Annonce-id") Long idAnnonce) {
	return annonceService.getAnnonce(idAnnonce);
	}

@GetMapping(value = "/recherche")
public List<Annonce> RechercherAnnonce(@RequestParam String lieu,@RequestParam double prix)
{	
	return annonceService.getRecherche(lieu, prix);
}
}