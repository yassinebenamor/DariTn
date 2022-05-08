import { Component, OnInit } from '@angular/core';
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {RendezVous} from "../../../Modal/rendez-vous";
import {RendezVousService} from "../../../Service/rendez-vous.service";

@Component({
  selector: 'app-rendez-vous',
  templateUrl: './rendez-vous.component.html',
})
export class RendezVousComponent implements OnInit {

  listrdvs : any;
  form : boolean =false;
  rdv!:RendezVous
  closeResult!:String
  constructor(private rdvs : RendezVousService,private modalService : NgbModal) { }

  ngOnInit(): void {
    this.getrdvs();
    this.rdv = {
      id: null,
      date: null,
      heur:null,
      region:null,
      lieu:null,
      etat:null,
      annonce:null,
      demandeur:null
    }
  }
  private getrdvs() {
    this.rdvs.getAllRendezVous().subscribe((res) =>this.listrdvs = res);
  }
  addrdvs(rdv:any){
    this.rdvs.AddRendezVous(rdv).subscribe(()=>{
      this.getrdvs();
      this.form=false;
    })
  }
  Editrdv(rdv:any)
  {
    this.rdvs.EditRendezVous(rdv).subscribe();
  }
  Deleterdv(idrdv:any){
    this.rdvs.DeleteRendezVous(idrdv).subscribe(()=>this.getrdvs())
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
