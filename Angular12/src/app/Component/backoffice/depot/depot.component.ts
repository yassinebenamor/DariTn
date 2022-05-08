import { Component, OnInit } from '@angular/core';
import {ContratLocation} from "../../../Modal/contrat-location";
import {ContratLocationService} from "../../../Service/contrat-location.service";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {DepotDeGarantiesService} from "../../../Service/depot-de-garanties.service";
import {DepotDeGaranties} from "../../../Modal/depot-de-garanties";

@Component({
  selector: 'app-depot',
  templateUrl: './depot.component.html',
  styleUrls: ['./depot.component.css']
})
export class DepotComponent implements OnInit {

  p:number=1;
  listDepot : any;
  form : boolean =false;
  depot!:DepotDeGaranties
  closeResult!:String
  constructor(private depotS : DepotDeGarantiesService,private modalService : NgbModal) { }

  ngOnInit(): void {
    this.getDepot();
    this.depot = {
      id:null,
      moisLoyers:null,
      Somme:null,
      numeroPayment:null,
      caution:null,
      editedAt:null,
      etat:null,
      user:null
    }
  }
  getDepot()
  {
    this.depotS.getDepot().subscribe((res) =>this.listDepot = res);
  }
  addDepot(depot:any,image:any)
  {
    this.depotS.AddDepot(depot,image).subscribe(()=>{
      this.getDepot();
      this.form=false;
    })
  }
  EditDepot(depot:any,image:any)
  {
    this.depotS.UpdateDepot(depot,image).subscribe();
  }
  DeleteContratLocation(idDep:any)
  {
    this.depotS.DeleteDepot(idDep).subscribe(()=>this.getDepot())
  }
  Validate(id:any)
  {
    this.depotS.Validate(id).subscribe()
  }
  Refuse(id:any)
  {
    this.depotS.Refuse(id).subscribe()
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
