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
import Daritn.spring.entity.ContratAchat;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.service.ContratAchatService;



@RestController
@RequestMapping("contratAchat")
@CrossOrigin("*")
public class ContratAchatController {
	
	@Autowired
     private ContratAchatService contratachatService;

	
	@GetMapping("/allContratAchat")
	@ResponseBody
	List<ContratAchat> retrieveAllContratAchat() {
		return contratachatService.retrieveAllContratAchat();
	}
	
	/*@PostMapping(value = "/addContratAchat")

	ContratAchat addContratAchat () {
		ContratAchat ca = new ContratAchat(1L,new Date(),"test","waiting",new User(1L),new Annonce(1L)) ;
		
		return contratachatService.addContratAchat(ca);
	}*/
	
	
	@PostMapping(value = "/addContratAchat")

	ContratAchat addContratAchat (@RequestBody ContratAchat ca) {
		ca.setEtat(EnumeratedEtat.Waiting);
		
		return contratachatService.addContratAchat(ca);
	}
	
	/*@PutMapping(value = "/updateContratAchat")

	ContratAchat updateContratAchat () {
		ContratAchat ca = new ContratAchat(2L,new Date(),"updated","waiting",new User(1L),new Annonce(1L)) ;
		
		return contratachatService.addContratAchat(ca);
	}*/
	
	/*@PutMapping(value = "/updateContratAchat")

	ContratAchat updateContratAchat (@RequestBody ContratAchat ca	) {
		return contratachatService.updateContratAchat(ca);
	}*/
	
	@PutMapping(value = "/updateContratAchat")

	ContratAchat validateContratAchat (@RequestBody ContratAchat ca	) {
		return contratachatService.updateContratAchat(ca);
	}
	
	/*@GetMapping("/SimulationCreditbyid")

	ContratAchat retrieveContratAchat (Long id) {
		return null;
	}*/

	@DeleteMapping(value = "/deleteContratAchat")

	void removeContratAchat (@RequestParam Long id) {
		contratachatService.removeContratAchat(id);			
	}
	
	@GetMapping("/SearchContratAchat")
	List<ContratAchat> SearchSimulationCredit(@RequestParam String etat, String regle) {
		return contratachatService.SearchContratAchat(etat, regle);
	}

	@GetMapping("/allJContratAchat")
	@ResponseBody
	List<ContratAchat> retrieveAllJContratAchat(@RequestParam Long id) {
		return contratachatService.retrieveAllJContratAchat(id);
	}
	@PutMapping(value="confirm")
	public int Confirm(@RequestParam Long id)
	{
		return contratachatService.Validate(EnumeratedEtat.Confirmed, id);	
	}	
	

	@PutMapping(value="/refuse")
  	public int Refuse(@RequestParam Long id)
	{
	return contratachatService.Validate(EnumeratedEtat.Refused, id);	
	}
	
	@GetMapping(value="/statWaiting")
  	public float statWaitingContrat(String etat)
	{
	return contratachatService.statContrat("Waiting");	
	}
	@GetMapping(value="/statRefused")
  	public float statRefusedContrat(String etat)
	{
	return contratachatService.statContrat("Refused");	
	}
	@GetMapping(value="/statConfirmed")
  	public float statConfirmedContrat(String etat)
	{
	return contratachatService.statContrat("Confirmed");	
	}
	
}
