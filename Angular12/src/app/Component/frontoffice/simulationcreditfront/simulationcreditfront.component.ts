import { Component, OnInit } from '@angular/core';
import {Simulationcredit} from "../../../Modal/simulationcredit";
import {SimulationcreditService} from "../../../Service/simulationcredit.service";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-simulationcreditfront',
  templateUrl: './simulationcreditfront.component.html',
  styles: []
})
export class SimulationcreditfrontComponent implements OnInit {

  listSimulationcredit : any;
  count: any;
  form : boolean = false;
  simulationcredit!: Simulationcredit;
  closeResult! : string;

  constructor(private sc : SimulationcreditService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAllSimulationCredit();

    this.simulationcredit = {
      id: null,
      salaire: null,
      plafond: null,
      autofinancement: null,
      annee: null,
      mensualite: null
    }
  }

  getAllSimulationCredit(){
    this.sc.getAllSimulationCredit().subscribe(res => this.listSimulationcredit = res)
  }

  getAllSimulationCreditSorted(){
    this.sc.getTrieSimulation().subscribe(res => this.listSimulationcredit = res)
  }
  getAllSimulationCreditSearch( event : any){
    console.log(event.target.value.length);
if (event.target.value.length == 0) {
  this.sc.getAllSimulationCredit().subscribe(res => this.listSimulationcredit = res)
}
else {
  this.sc.getSearchSimulation(event.target.value).subscribe(res => this.listSimulationcredit = res)
}
  }
  addSimulationCredit(simulationcredit: any){
    this.sc.addSimulationCredit(simulationcredit).subscribe(() => {
      this.getAllSimulationCredit();
      this.form = false;
    });
  }

  /*editSimulation(simulationcredit : Simulationcredit){
    this.sc.editSimulationCredit(simulationcredit).subscribe(() => {
      this.getAllSimulationCredit();
      this.form = false;
    });
  }*/
  deleteSimulation(id : any){
    this.sc.deleteSimulationCredit(id).subscribe(() => this.getAllSimulationCredit())
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
