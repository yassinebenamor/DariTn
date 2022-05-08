import { Component, OnInit } from '@angular/core';
import {ContratLocation} from "../../../Modal/contrat-location";
import {ContratLocationService} from "../../../Service/contrat-location.service";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-contrat-de-location',
  templateUrl: './contrat-de-location.component.html',
  styles: [
  ]
})
export class ContratDeLocationComponent implements OnInit {
  listCLocations : any;
  form : boolean =false;
  contratlocation!:ContratLocation
  closeResult!:String
  constructor(private cls : ContratLocationService,private modalService : NgbModal) { }

  ngOnInit(): void {
    this.getContratLocations(1);
    this.contratlocation = {
      id:null,
      nom:null,
      dateDebut:null,
      dateFin:null,
      reglement:null,
      etat:null,
      Locataire:null,
      Annonce:null,
    }
  }
  private getContratLocations(iduser:any) {
    this.cls.getAllContratByUser(iduser).subscribe((res) =>this.listCLocations = res);
  }
  addContratLocation(Contratlocation:any){
    this.cls.AddContrat(Contratlocation).subscribe(()=>{
      this.getContratLocations(1);
      this.form=false;
    })
  }
  DeleteContratLocation(idContratLocation:any){
    this.cls.DeleteContrat(idContratLocation).subscribe(()=>this.getContratLocations(1))
  }
  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
  closeForm(){

  }
  cancel(){
    this.form = false;
  }

}
