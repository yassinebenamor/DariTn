package Daritn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Daritn.spring.entity.Estimation;
import Daritn.spring.service.EstimationService;

@RestController
@RequestMapping("estimation")
@CrossOrigin("*")
public class EstimationController {

    @Autowired
	private EstimationService estimationService;

    @PostMapping("/Estimate")
	@ResponseBody
	Double retrieveAllContratAchat(@RequestBody Estimation e) {
		return estimationService.estimationAchat(e);
	}
}
