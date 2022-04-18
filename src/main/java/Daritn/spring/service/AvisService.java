package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Avis;
import Daritn.spring.repository.AvisRepository;

@Service
public class AvisService implements IAvisService {

	@Autowired
	AvisRepository avisRepo;
		
		@Override
		public List<Avis> retrieveAllAvis() {
			List<Avis> av = (List<Avis>) avisRepo.findAll();
			return av;
		}

		@Override
		public Avis addAvis(Avis c) {
			return avisRepo.save(c); 
		}

		@Override
		public String deleteAvis(Integer id) {
			if(avisRepo.findById(id).orElse(null) != null) {
				avisRepo.deleteById(id);
				return "feedback removed successfully!";
			}
			else return "feedback id not found!";
		}

		@Override
		public Avis updateAvis(Avis c) {
			return avisRepo.save(c);
		}

		

		@Override
		public Avis retrieveAvis(int idR) {
			return avisRepo.findById(idR).orElse(null);
		}

		
		
}
