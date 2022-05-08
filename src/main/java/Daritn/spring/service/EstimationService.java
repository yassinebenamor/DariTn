package Daritn.spring.service;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Estimation;


@Service
public class EstimationService {
	
	
	public Double estimationAchat(Estimation estimation) {
		
		Double e;
		
		if(estimation.getRegion().toString().equals("Tunis" ) || estimation.getRegion().toString().equals("Sfax")) {
			e=1.6;}
		else if(estimation.getRegion().toString().equals("Mahdia" ) || estimation.getRegion().toString().equals("Sousse") || estimation.getRegion().toString().equals("Mestir") || estimation.getRegion().toString().equals("Bizerte")|| estimation.getRegion().toString().equals("Nabeul"))
			e=1.4;
		else if(estimation.getRegion().toString().equals("Ariana" ) || estimation.getRegion().toString().equals("BenArous") || estimation.getRegion().toString().equals("Mestir") || estimation.getRegion().toString().equals("Bizerte"))
		    e=1.3;
			else {
			e=1.0;
			
		}
		
		if(estimation.isAppartement()) {
			System.out.println("appartement");
			if(estimation.isStanding())
			{
				System.out.println("1e="+e);
			
			e*=estimation.getSurface()*18000;
			System.out.println("2e="+e);

			}
			else
			e*=estimation.getSurface()*15000;
		}
		else {
			System.out.println("!appartement");

			if(estimation.isStanding())
			e*=estimation.getSurface()*4;
			else
			e*=estimation.getSurface()*2;
		}
		    
		  if(estimation.getAnnee()<2000)
			  e-=estimation.getSurface()*500;
         
		  if(estimation.isTravaux())
			  e-=estimation.getSurface()*175;
		  
		  if(estimation.isMeubles())
			  e+=200;
		  
		  if(estimation.getNbchambres()<=2)
			  e+=estimation.getSurface()*200;
		  else
		       e+=estimation.getSurface()*250;
		  
		  
			  
		  return e;	
	}

}
