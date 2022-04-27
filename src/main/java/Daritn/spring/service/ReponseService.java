package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Reponse;
import Daritn.spring.repository.ReponseRepository;

@Service
public class ReponseService implements IReponseService {

		@Autowired
		ReponseRepository ReponseRepo;
		
		@Override
		public List<Reponse> retrieveAllReponse() {
			List<Reponse> av = (List<Reponse>) ReponseRepo.findAll();
			return av;
		}

		@Override
		public Reponse addReponse(Reponse c) {
			return ReponseRepo.save(c); 
		}

		@Override
		public String deleteReponse(Integer id) {
			if(ReponseRepo.findById(id).orElse(null) != null) {
				ReponseRepo.deleteById(id);
				return "Reponse removed successfully!";
			}
			else return "Reponse id not found!";
		}

		@Override
		public Reponse updateidReponse(Reponse c) {
			return ReponseRepo.save(c);
		}

		

		@Override
		public Reponse retrieveidReponse(int idR) {
			return ReponseRepo.findById(idR).orElse(null);
		}


	
}
