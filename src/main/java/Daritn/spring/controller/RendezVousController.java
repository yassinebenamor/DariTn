package Daritn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import Daritn.spring.entity.RendezVous;
import Daritn.spring.service.RendezVousService;

@RestController
@RequestMapping("rdv")
@CrossOrigin("*")
public class RendezVousController {
	
	@Autowired
	private RendezVousService RdvService;
	
	@GetMapping("/")
	@ResponseBody
	public List<RendezVous> getRdv()
	{	
		return RdvService.getRdv();
	}
	
	@GetMapping(value="/retrieverdv")
	@ResponseBody
	public RendezVous Retrieverdv(@RequestParam Long id)
	{
		Long idd=1L;
		return RdvService.retrieveRdv(idd);
	}
	
	@PostMapping(value = "/saverdv")
	public RendezVous Addrdv(@RequestBody RendezVous rdv)
	{	
		return RdvService.addRdv(rdv);
	}
	
	@PutMapping(value = "/updaterdv")
	public RendezVous Editrdv(@RequestBody RendezVous rdv)
	{	
		return RdvService.EditRdv(rdv);
	}
	
	@DeleteMapping(value = "/deleterdv")
	public void Deleterdv(@RequestParam Long id)
	{	
		Long idd=1L;
		RdvService.DeleteRdv(idd);
	}
	@GetMapping(value = "/r")
	public List<RendezVous> Rechercherdv(@RequestParam String lieu,@RequestParam String etat)
	{	
		return RdvService.getRecherche(lieu, etat);
	}
}
