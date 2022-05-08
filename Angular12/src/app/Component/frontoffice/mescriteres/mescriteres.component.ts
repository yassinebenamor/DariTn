import { Component, OnInit } from '@angular/core';
import {Simulationcredit} from "../../../Modal/simulationcredit";
import {SimulationcreditService} from "../../../Service/simulationcredit.service";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Mescriteres} from "../../../Modal/mescriteres";
import {MescriteresService} from "../../../Service/mescriteres.service";

@Component({
  selector: 'app-mescriteres',
  templateUrl: './mescriteres.component.html',
  styleUrls: ['./mescriteres.component.css']
})
export class MescriteresComponent implements OnInit {

  listMescriteres : any;
  form : boolean = false;
  mescriteres!: Mescriteres;
  closeResult! : string;

  constructor(private sc : MescriteresService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAllMescriteres();;

    this.mescriteres= {
      id: null,
      minPrix: null,
      maxPrix: null,
      minSurface: null,
      maxSurface: null,
      minPrixm2: null,
      maxPrixm2: null,
      region: null,
      acheteur: null,
    }
  }

  getAllMescriteres(){
    this.sc.getAllMescriteres().subscribe(res => this.listMescriteres = res)
  }

  addMescriteres(mescriteres: any){
    this.sc.addMescriteres(mescriteres).subscribe(() => {
      this.getAllMescriteres();
      this.form = false;
    });
  }

  /*editMescriteres(mescriteres : Mescriteres){
    this.sc.editMescriteres(mescriteres).subscribe();
  }*/
  deleteMescriteres(id : any){
    this.sc.deleteMescriteres(id).subscribe(() => this.getAllMescriteres())
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
