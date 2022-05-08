import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Contratachat } from '../../../Modal/contratachat';
import { ContratachatService } from '../../../Service/contratachat.service';
import { NgToastService} from 'ng-angular-popup'

@Component({
  selector: 'app-contratachat',
  templateUrl: './contratachat.component.html',
  styleUrls: ['./contratachat.component.css']
})
export class ContratachatComponent implements OnInit {

  listContratachat : any;
  listContratachatByID : any;

  form : boolean = false;
  contratachat!: Contratachat;
  closeResult! : string;

  constructor(private ca : ContratachatService , private modalService: NgbModal, private toast : NgToastService) { }

  ngOnInit(): void {

    this.getAllContratAchat();

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
  getAllContratAchatByUserID(idUser : any){
    this.ca.getAllContratAchatByUserID(1).subscribe(res => this.listContratachatByID = res)
  }

  getAllContratAchatSearch(etat : any, reglement: any){
     console.log(etat)
    console.log(reglement)
      this.ca.SearchContratAchat(etat,reglement).subscribe(res => this.listContratachat = res)
  }

  addContratAchat(contratachat: any){
    this.ca.addContratAchat(contratachat).subscribe(() => {
      this.getAllContratAchat();
      this.toast.success({detail:"SUCCESS",summary:'Your Success Message', duration:5000});
      this.form = false;
    });
  }

  editContratAchat(contratachat : Contratachat){
    this.ca.editContratAchat(contratachat).subscribe();
  }

  deleteContratAchat(id : any){
    this.ca.deleteContratAchat(id).subscribe(() => this.getAllContratAchat())
  }

  ConfirmContratAchat(id : any){
    this.ca.ConfirmContratAchat(id).subscribe(() => this.getAllContratAchat())
  }

  RefuseContratAchat(id : any){
    this.ca.RefuseContratAchat(id).subscribe(() => this.getAllContratAchat())
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
