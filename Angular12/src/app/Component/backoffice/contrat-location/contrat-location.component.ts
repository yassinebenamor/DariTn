import { Component, OnInit } from '@angular/core';
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ContratLocationService} from "../../../Service/contrat-location.service";
import {ContratLocation} from "../../../Modal/contrat-location";
import { NgToastService} from 'ng-angular-popup'
@Component({
  selector: 'app-contratlocation',
  templateUrl: './contrat-location.component.html',
})
export class ContratLocationComponent implements OnInit {

  p:number=1;
  listCLocations : any;
  form : boolean =false;
  contratlocation!:ContratLocation
  closeResult!:String
  constructor(private cls : ContratLocationService,private modalService : NgbModal, private toast : NgToastService) { }

  ngOnInit(): void {
    this.getContratLocations();
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
  getContratLocations()
  {
    this.cls.getAllContrat().subscribe((res) =>this.listCLocations = res);
  }
  addContratLocation(Contratlocation:any)
  {
    this.cls.AddContrat(Contratlocation).subscribe(()=>{
      this.getContratLocations();
      this.form=false;
    })
  }
  EditContratLocation(Contratlocation:any)
  {
    this.cls.EditContrat(Contratlocation).subscribe();
  }
  DeleteContratLocation(idContratLocation:any)
  {
    this.cls.DeleteContrat(idContratLocation).subscribe(()=>this.getContratLocations())
  }
  Tri()
  {
    this.cls.Tri().subscribe((res) => this.listCLocations = res);
  }
  Validate(id:any)
  {
    this.cls.Validate(id).subscribe(()=>this.getContratLocations())
    this.toast.success({detail:"SUCCESS",summary:'Validated with success', duration:5000});
  }
  Refuse(id:any)
  {
    this.cls.Refuse(id).subscribe(()=>this.getContratLocations())
    this.toast.success({detail:"SUCCESS",summary:'Refused with success', duration:5000});
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
