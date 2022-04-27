package Daritn.spring.service;

import java.util.List;

import Daritn.spring.entity.Reponse;


public interface IReponseService {
	List<Reponse> retrieveAllReponse();
	Reponse addReponse(Reponse c);
	String deleteReponse(Integer idQ);
	Reponse updateidReponse(Reponse c);
	Reponse retrieveidReponse(int idQ);
}
