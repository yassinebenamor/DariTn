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

import Daritn.spring.entity.ContratLocation;
import Daritn.spring.service.ContratLocationService;

@RestController
@RequestMapping("contratlocation")
@CrossOrigin("*")
public class ContratLocationController {
	@Autowired
	private ContratLocationService contratLocationService;
	
	@GetMapping("/")
	@ResponseBody
	public List<ContratLocation> getContratLs()
	{	
		return contratLocationService.getContratLs();
	}
	
	@GetMapping(value="/retrievecl")
	@ResponseBody
	public ContratLocation RetrieveContratL(@RequestParam Long id)
	{
		Long idd=1L;
		return contratLocationService.retrieveContratLocation(idd);
	}
	
	@PostMapping(value = "/savecontratL")
	public ContratLocation AddContratL(@RequestBody ContratLocation clo)
	{	
		return contratLocationService.addContratLocation(clo);
	}
	
	@PutMapping(value = "/updateContratL")
	public ContratLocation EditContratL(@RequestBody ContratLocation clo)
	{	
		return contratLocationService.EditContratLocation(clo);
	}
	
	@DeleteMapping(value = "/deleteContratL")
	public void DeleteContratL(@RequestParam Long id)
	{	
		Long idd=1L;
		contratLocationService.DeleteContratLocation(idd);
	}
	
	@GetMapping(value="/retrieve")
	@ResponseBody
	public List<ContratLocation> GetAllByIdUser(@RequestParam Long id)
	{
		return contratLocationService.getAllByIdUser(id);
	}
	
	@GetMapping(value="/orderbyetatprix")
	@ResponseBody
	public List<ContratLocation> SortByEtat()
	{
		return contratLocationService.TrieByEtatPrix();
	}
}
