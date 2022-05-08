import { Component, OnInit } from '@angular/core';
import {Estimation} from "../../../Modal/estimation";
import {EstimationService} from "../../../Service/estimation.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-estimation',
  templateUrl: './estimation.component.html',
  styleUrls: ['./estimation.component.css']
})
export class EstimationComponent implements OnInit {
  estimationresultat : any;
  form : boolean = false;
  estimation!: Estimation;

  constructor(private sc : EstimationService, private modalService: NgbModal) { }

  ngOnInit(): void {

    this.estimation = {
      appartement: null,
      region: null,
      surface: null,
      nbchambres: null,
      annee: null,
      travaux: null,
      standing: null,
      meubles: null,
      periode: null,
    }
  }


  getEstimation(estimation:any){

    if(estimation.appartement=="0")
      estimation.appartement=false
    else
      estimation.appartement=true
    if(estimation.travaux=="0")
      estimation.travaux=false
    else
      estimation.travaux=true
    if (estimation.meubles=="0")
      estimation.meubles=false
    else
      estimation.meubles=true
    if(estimation.standing=="0")
      estimation.standing=false
    else
      estimation.standing=true
    if(estimation.periode=="0")
      estimation.periode=false
    else
      estimation.periode=true


    console.log(estimation)
    this.sc.GetEstimation(estimation).subscribe((res)=>this.estimationresultat= res)
  }

}
