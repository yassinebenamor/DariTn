import { Component, OnInit } from '@angular/core';
import {Location} from "../../../Modal/location";
import {LocationService} from "../../../Service/location.service";
import {ModalDismissReasons, NgbModal, NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {ContratLocation} from "../../../Modal/contrat-location";
import {ContratLocationService} from "../../../Service/contrat-location.service";
@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
})
export class LocationComponent implements OnInit {
  listLocations : any;
  form : boolean =false;
  location!:Location
  closeResult!:String
  constructor(private ls : LocationService,private modalService : NgbModal) { }

  ngOnInit(): void {
    this.getLocations();
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
  }
  private getLocations() {
    this.ls.getAllLocation().subscribe((res) =>this.listLocations = res);
  }


  addLocation(location:any){
    this.ls.AddLocation(location).subscribe(()=>{
      this.getLocations();
      this.form=false;
    })
  }
  EditLocation(location:any)
  {
    this.ls.EditLocation(location).subscribe();
  }
  DeleteLocation(idLocation:any){
    this.ls.DeleteLocation(idLocation).subscribe(()=>this.getLocations())
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
