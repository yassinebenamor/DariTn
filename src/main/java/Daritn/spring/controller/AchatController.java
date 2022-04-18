package Daritn.spring.controller;

import java.util.Date;
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

import Daritn.spring.entity.Achat;
import Daritn.spring.entity.Annonce;
import Daritn.spring.entity.ContratAchat;
import Daritn.spring.entity.User;
import Daritn.spring.service.AchatService;

@RestController
@RequestMapping("achat")
@CrossOrigin("*")
public class AchatController {
	
	@Autowired
    private AchatService achatService;
	
	@GetMapping("/allAchat")
	@ResponseBody
	public List<Achat> retrieveAllAchat() {
		return achatService.retrieveAllAchat();
	}

	@PostMapping(value = "addAchat")
	public Achat addAchat (@RequestBody Achat a) {
		
		return achatService.addAchat(a);
	}
	
	/*@PostMapping(value = "/addAchat")

	Achat addAchat () {
		Achat a = new Achat(1L,new ContratAchat(2L)) ;
		
		return achatService.addAchat(a);
	}*/
	
	@PutMapping(value = "updateAchat")
	public Achat updateAchat (@RequestBody Achat a) {
		return achatService.updateAchat(a);
	}
	
	@DeleteMapping(value = "/deleteAchat")
	void removeAchat (@RequestParam Long id) {
		achatService.removeAchat(id);
	}
	
	/*@PutMapping(value = "/updateAchat")

	Achat updateAchat () {
		Achat a = new Achat(1L,new ContratAchat(3L)) ;
	
		return achatService.updateAchat(a);
	}

	public Achat retrieveAchat (Long id) {
		return null;
	}*/
	
	
	
}
