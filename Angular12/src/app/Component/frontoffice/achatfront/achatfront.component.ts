import { Component, OnInit } from '@angular/core';
import {Achat} from "../../../Modal/achat";
import {AchatService} from "../../../Service/achat.service";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-achatfront',
  templateUrl: './achatfront.component.html',
  styles: [
  ]
})
export class AchatfrontComponent implements OnInit {



  listAchat : any;
  form : boolean = false;
  achat!: Achat;

  closeResult! : string;

  constructor(private ac : AchatService, private modalService: NgbModal) {}

  ngOnInit(): void {
    this.getAllAchat();

    this.achat = {
      id: null,
      date: null,
      etat: null,
      annonce: null,
      acheteur: null,
    }
  }

  getAllAchat(){
    this.ac.getAllAchat().subscribe(res => this.listAchat = res)
  }



  /*editAchat(achat : Achat){
    this.ac.editAchat(achat).subscribe();
  }*/
  deleteAchat(id : any){
    this.ac.deleteAchat(id).subscribe(() => this.getAllAchat())
  }


}
