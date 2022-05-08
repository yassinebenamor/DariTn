package Daritn.spring.service;

import java.util.List;

import Daritn.spring.entity.Avis;


public interface IAvisService  {
	public List<Avis> retrieveAllAvis();
	public Avis addAvis(Avis c);
	public String deleteAvis(Integer idAvis);
	public Avis updateAvis(Avis c);
	public Avis retrieveAvis(int idAvis);
		

}
