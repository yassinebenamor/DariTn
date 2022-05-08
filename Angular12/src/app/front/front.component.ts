import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Location} from "../Modal/location";
import {LocationService} from "../Service/location.service";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {RendezVous} from "../Modal/rendez-vous";
import {RendezVousService} from "../Service/rendez-vous.service";
import {DepotDeGaranties} from "../Modal/depot-de-garanties";
import {DepotDeGarantiesService} from "../Service/depot-de-garanties.service";
import {HttpClient} from "@angular/common/http";
import {EstimationService} from "../Service/estimation.service";
import {Estimation} from "../Modal/estimation";
@Component({
  selector: 'app-front',
  templateUrl: './front.component.html',
  styles: [
  ]
})
export class FrontComponent implements OnInit {
  form : boolean =false;
  location!:Location
  rdv!:RendezVous
  depot!:DepotDeGaranties
  estimation!:Estimation
  EstimationValue:any;

  constructor(private ls : LocationService,private ddg : DepotDeGarantiesService,private rdvs : RendezVousService,private modalService : NgbModal,private httpClient : HttpClient,private EstimationS :EstimationService) { }
  ngOnInit(): void {
    this.location = {
      id: null,
      typelocation: null,
      dateDebut:null,
      etat:null,
      dateFin:null,
      bien:null,
      garanties:null,
      locataire: null
    }
    this.rdv = {
      id: null,
      date: null,
      heur:null,
      region:null,
      lieu:null,
      etat:null,
      annonce:null,
      demandeur:null
    }
    this.depot = {
      id:null,
      moisLoyers:null,
      Somme:null,
      numeroPayment:null,
      caution:null,
      editedAt:null,
      etat:null,
      user:null,
    }
    this.estimation = {
      appartement:null,
      region:null,
      surface:null,
      nbchambres:null,
      annee:null,
      travaux:null,
      standing:null,
      meubles:null,
      periode:null,
    }

  }

  addLocation(location:any,Depot:any){
    location.garanties=Depot;
    this.ls.AddLocation(location).subscribe(()=>{
      this.form=false;
    })
  }
  addrdvs(rdv:any){
    this.rdvs.AddRendezVous(rdv).subscribe(()=>{
      this.form=false;
    })
  }
  addDepot(Depot:any,caution:any){
    this.ddg.AddDepot(Depot,caution).subscribe(()=>{
      this.form=false;
    })
  }
  getEstimation(estimation:any){

    if(estimation.appartement=="0")
      estimation.appartement=false
    else
      estimation.appartement=true
    if(estimation.travaux=="0")
      estimation.travaux=false
    else
      estimation.travaux=true
    if (estimation.meubles=="0")
      estimation.meubles=false
    else
      estimation.meubles=true
    if(estimation.standing=="0")
      estimation.standing=false
    else
      estimation.standing=true
    if(estimation.periode=="0")
      estimation.periode=false
    else
      estimation.periode=true


    console.log(estimation)
    this.EstimationS.GetEstimation(estimation).subscribe((res)=>this.EstimationValue= res)
  }
}
