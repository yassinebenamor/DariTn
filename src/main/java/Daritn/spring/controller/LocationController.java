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

import Daritn.spring.entity.Location;
import Daritn.spring.service.LocationService;


@RestController
@RequestMapping("location")
@CrossOrigin("*")
public class LocationController {
	
	@Autowired
	private LocationService LocationService;
	
	@GetMapping("/")
	@ResponseBody
	public List<Location> getContratLs()
	{	
		return LocationService.getLocations();
	}
	
	@GetMapping(value="/retrievelocation")
	@ResponseBody
	public Location RetrieveContratL(@RequestParam Long id)
	{
		Long idd=1L;
		return LocationService.retrieveLocation(idd);
	}
	
	@PostMapping(value = "/saveLocation")
	public Location AddContratL(@RequestBody Location Location)
	{	
		return LocationService.addLocation(Location);
	}
	
	@PutMapping(value = "/updateLocation")
	public Location EditContratL(@RequestBody Location Location)
	{	
		return LocationService.EditLocation(Location);
	}
	@DeleteMapping(value = "/deleteLocation")
	public void DeleteContratL(@RequestParam Long id)
	{	
		Long idd=1L;
		LocationService.DeleteContratLocation(idd);
	}
}
