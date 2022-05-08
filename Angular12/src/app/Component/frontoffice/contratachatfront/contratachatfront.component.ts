import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Contratachat} from "../../../Modal/contratachat";
import {ContratachatService} from "../../../Service/contratachat.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-contratachatfront',
  templateUrl: './contratachatfront.component.html',
  styles: [
  ]
})
export class ContratachatfrontComponent implements OnInit {

  listContratachat : any;
  listContratachatByID : any;

  form : boolean = false;
  contratachat!: Contratachat;
  closeResult! : string;

  constructor(private ca : ContratachatService, private modalService: NgbModal) { }

  ngOnInit(): void {

    this.getAllContratAchat();
    this.getAllContratAchatByUserID(1);


    this.contratachat = {
      id: null,
      dateAchat: null,
      reglement: null,
      etat: null,
      acheteur: null,
      annonce: null
    }
  }

  getAllContratAchat(){
    this.ca.getAllContratAchat().subscribe(res => this.listContratachat = res)
  }

  getAllContratAchatByUserID(id : any){
    this.ca.getAllContratAchatByUserID(1).subscribe(res => this.listContratachatByID = res)
  }
  addContratAchat(contratachat: any){
    this.ca.addContratAchat(contratachat).subscribe(() => {
      this.getAllContratAchat();
      this.form = false;
    });
  }

  /*editContratAchat(contratachat : Contratachat){
    this.ca.editContratAchat(contratachat).subscribe();
  }*/
  deleteContratAchat(id : any){
    this.ca.deleteContratAchat(id).subscribe(() => this.getAllContratAchat())
  }

}
