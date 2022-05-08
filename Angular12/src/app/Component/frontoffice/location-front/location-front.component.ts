import { Component, OnInit } from '@angular/core';
import {Location} from "../../../Modal/location";
import {LocationService} from "../../../Service/location.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Estimation} from "../../../Modal/estimation";

@Component({
  selector: 'app-location-front',
  templateUrl: './location-front.component.html',
  styles: [
  ]
})
export class LocationFrontComponent implements OnInit {
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
  DeleteLocation(idLocation:any){
    this.ls.DeleteLocation(idLocation).subscribe(()=>this.getLocations())
  }

}
