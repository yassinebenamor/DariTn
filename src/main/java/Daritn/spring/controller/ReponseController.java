package Daritn.spring.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Daritn.spring.entity.Reponse;
import Daritn.spring.service.ReponseService;


@RequestMapping("Reponse/")
@RestController
public class ReponseController {
    @Autowired
    ReponseService avServ;

    @PostMapping("/addReponse")
    public Reponse addReponse(@RequestBody Reponse b) {
    	return avServ.addReponse(b);
    }

    @DeleteMapping("/deleteReponse/{id}")
    public String deletReponse(@PathVariable String id) {
    	
       return avServ.deleteReponse(Integer.parseInt(id));
    }

    @PutMapping("/updateReponse")
    public Reponse updateReponse(@RequestBody Reponse b) {
        return avServ.updateidReponse(b);
    }

    @GetMapping("/getReponseList")
    public ArrayList<Reponse> getReponseList() {
    	for(Reponse l : avServ.retrieveAllReponse()) {
    		try {
    			String bg = l.getText().replaceAll("good","*****");
    			System.out.println(bg);
    			l.setText(bg);
    		}catch(NullPointerException e) {
    			
    		}
    	
    	}
        return (ArrayList<Reponse>) avServ.retrieveAllReponse();
    }


    @GetMapping("/getReponse/{id}")
    public Reponse getReponsebyId(@PathVariable int id) {
        return avServ.retrieveidReponse(id);
    }
/*
    @GetMapping("/getQuantity/{id}")
    public int getQuantity(@PathVariable int id) {
        return avServ.getQuantity(id);
    }*/

}