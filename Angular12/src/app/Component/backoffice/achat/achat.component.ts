import {  Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Achat } from '../../../Modal/achat';
import { Contratachat } from '../../../Modal/contratachat';
import { AchatService } from '../../../Service/achat.service';
import {ContratachatService} from "../../../Service/contratachat.service";

@Component({
  selector: 'app-achat',
  templateUrl: './achat.component.html',
  styleUrls: ['./achat.component.css']
})
export class AchatComponent implements OnInit {

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

  addAchat(achat: any){
    this.ac.addAchat(achat).subscribe(() => {
      this.getAllAchat();
      this.form = false;
    });
  }

  editAchat(achat : Achat){
    this.ac.editAchat(achat).subscribe();
  }
  deleteAchat(id : any){
    this.ac.deleteAchat(id).subscribe(() => this.getAllAchat())
  }

  ConfirmAchat(id : any){
    this.ac.ConfirmAchat(id).subscribe(() => this.getAllAchat())
  }

  RefuseAchat(id : any){
    this.ac.RefuseAchat(id).subscribe(() => this.getAllAchat())
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
