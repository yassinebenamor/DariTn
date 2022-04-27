package Daritn.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Daritn.spring.entity.Quiz;
import Daritn.spring.service.QuizService;



@RestController
@RequestMapping("/Quiz")
public class QuizController {
	@Autowired 
	QuizService QuizService;
	
	@GetMapping("/retrieve-all-Quiz")
	@ResponseBody
	public List<Quiz> getQuiz(){
		return QuizService.retrieveAllQuiz();
	} 
	 
	@GetMapping("/retrieve-Quiz/{Quiz-id}")
	@ResponseBody
	public Quiz getClient(@PathVariable("Quiz-id") int idQuiz){
		return QuizService.retrieveidQuiz(idQuiz);
	}
	
	@PostMapping("/add-Quiz")
	@ResponseBody
	public Quiz addQuizt(@RequestBody Quiz c){
		return QuizService.addQuiz(c);
	}
	
	@DeleteMapping("/delete-Quiz/{id-Quiz}")
	@ResponseBody
	public void deleteQuiz(@PathVariable("id-Quiz") int idQuiz){
		QuizService.deleteQuiz(idQuiz);
	}
	
	@PutMapping("/modify-Quiz")
	@ResponseBody
	public Quiz modQuiz (@RequestBody Quiz c){
		return QuizService.addQuiz(c);
	}
	

}
