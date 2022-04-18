package Daritn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.RendezVous;
import Daritn.spring.service.RendezVousService;

@RestController
@RequestMapping("rdv")
@CrossOrigin("*")
public class RendezVousController {
	
	@Autowired
	private RendezVousService RdvService;
	@Autowired
	private JavaMailSender emailSender;
	
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
	public RendezVous Addrdv(@RequestBody RendezVous RendezVous)
	{	
		return RdvService.addRdv(RendezVous);
	}
	@PutMapping(value = "/updaterdv")
	public RendezVous Editrdv(@RequestBody RendezVous RendezVous)
	{	
		return RdvService.EditRdv(RendezVous);
	}
	@DeleteMapping(value = "/deleterdv")
	public void Deleterdv(@RequestParam Long id)
	{	
		RdvService.DeleteRdv(id);
	}
	@GetMapping(value = "/r")
	public List<RendezVous> Rechercherdv(@RequestParam String lieu,@RequestParam String etat,@RequestParam String region)
	{	
		return RdvService.getRecherche(lieu, etat,region);
	}
	@PutMapping(value="/validate")
	public int Validate(@RequestParam Long id)
	{
		return RdvService.Validate(EnumeratedEtat.Confirmed, id);	
	}
	@PutMapping(value="/refuse")
	public int Refuse(@RequestParam Long id)
	{
		return RdvService.Validate(EnumeratedEtat.Refused, id);	
	}
	
	@ResponseBody
    @RequestMapping("/sendEmail")
    public String sendSimpleEmail(@RequestParam String FRIEND_EMAIL) {
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo(FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");

        this.emailSender.send(message);

        return "Email Sent!";
	}
}
