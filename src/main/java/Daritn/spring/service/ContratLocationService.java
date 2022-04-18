package Daritn.spring.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.ContratLocation;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.repository.ContratLocationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContratLocationService {
	
	@Autowired
	private ContratLocationRepository contratLocationRepository;
	
	public List<ContratLocation> getContratLs(){
		List<ContratLocation> Contrats=contratLocationRepository.findAll();
		for (ContratLocation Contrat: Contrats) {
			System.out.println("Contrat :" + Contrat);
		}
		return Contrats;
	}
	public ContratLocation addContratLocation(ContratLocation cl) {
		return contratLocationRepository.save(cl);
	}
	public ContratLocation EditContratLocation(ContratLocation cl) {
		return contratLocationRepository.save(cl);
	}
	public void DeleteContratLocation(Long id) {
		contratLocationRepository.deleteById(id);
	}
	public ContratLocation retrieveContratLocation(Long id) {
		ContratLocation ContratLocation = contratLocationRepository.findById(id).orElse(null);
		System.out.println("Contrat de Location :" + ContratLocation);
		return ContratLocation; 
	}
	public List<ContratLocation> getAllByIdUser(Long id){
		List<ContratLocation> ContratLocations=contratLocationRepository.findAllContrat(id);
		for (ContratLocation ContratLocation: ContratLocations) {
			System.out.println("Contrat :" + ContratLocation);
		}
		return ContratLocations;
	}
	public List<ContratLocation> TrieByEtatPrix(){
		return contratLocationRepository.findAll(Sort.by("prixloyer").descending().and(Sort.by("etat")));
	}
	public int Validate(EnumeratedEtat etat,Long id)
	{
		return contratLocationRepository.updateEtat(etat, id);
	}
	public Page<ContratLocation> getContratLsUser(int iduser,int page, int size)
	{
		 return contratLocationRepository.findAllByLocataires(iduser, PageRequest.of(page,size));
	}
}
