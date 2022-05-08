import {  Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Simulationcredit } from '../../../Modal/simulationcredit';
import { SimulationcreditService } from '../../../Service/simulationcredit.service';

@Component({
  selector: 'app-simulationcredit',
  templateUrl: './simulationcredit.component.html',
  styleUrls: ['./simulationcredit.component.css']
})
export class SimulationcreditComponent implements OnInit {

  listSimulationcredit : any;
  form : boolean = false;
  simulationcredit!: Simulationcredit;
  closeResult! : string;
  p: number = 1;

  constructor(private sc : SimulationcreditService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAllSimulationCredit();;

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

  addSimulationCredit(simulationcredit: any){
    this.sc.addSimulationCredit(simulationcredit).subscribe(() => {
      this.getAllSimulationCredit();
      this.form = false;
    });
  }

  editSimulation(simulationcredit : Simulationcredit){
    this.sc.editSimulationCredit(simulationcredit).subscribe();
  }
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
