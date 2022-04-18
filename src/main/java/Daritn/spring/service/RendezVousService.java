package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.RendezVous;
import Daritn.spring.repository.RendezVousRepository;

@Service
public class RendezVousService {
	
	@Autowired
	RendezVousRepository rdvRepository;
	
	public List<RendezVous> getRdv(){
		List<RendezVous> RendezVous=rdvRepository.findAll();
		for (RendezVous rdv: RendezVous) {
			System.out.println("Contrat :" + rdv);
		}
		return RendezVous;
	}
	public RendezVous addRdv(RendezVous rdv) {
		return rdvRepository.save(rdv);
	}
	public RendezVous EditRdv(RendezVous rdv) {
		return rdvRepository.save(rdv);
	}
	public void DeleteRdv(Long id) {
		rdvRepository.deleteById(id);
	}
	public RendezVous retrieveRdv(Long id) {
		RendezVous RendezVous = rdvRepository.findById(id).orElse(null);
		System.out.println("RendezVous :" + RendezVous);
		return RendezVous; 
	}
	public List<RendezVous> getRecherche(String lieu,String Etat,String region){
		List<RendezVous> RendezVous=rdvRepository.RechercheMulti(lieu,Etat,region);
		for (RendezVous rdv: RendezVous) {
			System.out.println("Contrat :" + rdv);
		}
		return RendezVous;
	}
	public int Validate(EnumeratedEtat etat,Long id)
	{
		return rdvRepository.updateEtat(etat, id);
	}

	
}
