package Daritn.spring.service;

import Daritn.spring.entity.Reclamation;

public interface IReclamationService {
	Reclamation addReclamation(Reclamation c);
	String deleteReclamation(Integer idQ);
	Reclamation updateidReclamation(Reclamation c);
	Reclamation retrieveidReclamation(int idQ);
}
