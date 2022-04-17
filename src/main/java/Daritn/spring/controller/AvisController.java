package Daritn.spring.controller;

import java.util.ArrayList;
// imen mansouri

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Daritn.spring.entity.Avis;
import Daritn.spring.service.AvisService;

@RequestMapping("Avis/")
@RestController
public class AvisController {
    @Autowired
    AvisService avServ;

    @PostMapping("/addAvis")
    public Avis addAvis(@RequestBody Avis b) {
    	return avServ.addAvis(b);
    }

    @DeleteMapping("/deleteAvis/{id}")
    public String deletAvis(@PathVariable String id) {
    	
       return avServ.deleteAvis(Integer.parseInt(id));
    }

    @PutMapping("/updateAvis")
    public Avis updateAvis(@RequestBody Avis b) {
        return avServ.updateAvis(b);
    }

    @GetMapping("/getAvisList")
    public ArrayList<Avis> getAvisList() {
        return (ArrayList<Avis>) avServ.retrieveAllAvis();
    }


    @GetMapping("/getAvis/{id}")
    public Avis getAvisbyId(@PathVariable int id) {
        return avServ.retrieveAvis(id);
    }

    /*@GetMapping("/getQuantity/{id}")
    public int getQuantity(@PathVariable int id) {
        return avServ.getQuantity(id);
    }
*/

}