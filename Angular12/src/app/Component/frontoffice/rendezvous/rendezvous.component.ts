import { Component, OnInit } from '@angular/core';
import {RendezVous} from "../../../Modal/rendez-vous";
import {RendezVousService} from "../../../Service/rendez-vous.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import { ChartType, ChartOptions } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';
@Component({
  selector: 'app-rendezvous',
  templateUrl: './rendezvous.component.html',
})
export class RendezvousComponent implements OnInit {

  listrdvs : any;
  listTodayrdvs:any;
  form : boolean =false;
  rdv!:RendezVous
  closeResult!:String
  constructor(private rdvs : RendezVousService,private modalService : NgbModal) {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }

  ngOnInit(): void {
    this.getrdvs();
    this.getTodayRdv();
    this.rdv = {
      id: null,
      date: null,
      heur:null,
      region:null,
      lieu:null,
      etat:null,
      annonce:null,
      demandeur:null,
    }
  }
  getrdvs() {
    this.rdvs.getAllRendezVousByUser(1).subscribe((res) =>this.listrdvs = res);
  }
  getRecherche(region:any,etat:any,iduser:any)
  {
    console.log(region)
    console.log(etat)
    if(region==null || etat==null){
      this.rdvs.getAllRendezVousByUser(1).subscribe((res) =>this.listrdvs = res);
    }
    this.rdvs.RechercheCritere(region,etat,1).subscribe((res) =>this.listrdvs = res)
  }
  Editrdv(rdv:any)
  {
    this.rdvs.EditRendezVous(rdv).subscribe();
  }
  Deleterdv(idrdv:any){
    this.rdvs.DeleteRendezVous(idrdv).subscribe(()=>this.getrdvs())
  }
  getTodayRdv()
  {
    this.rdvs.TodayRendezVous(1).subscribe((res) =>this.listTodayrdvs = res);
  }
  public pieChartOptions: ChartOptions = {
    responsive: true,
  };
  public pieChartLabels: Label[] = [['SciFi'], ['Drama'], 'Comedy'];
  public pieChartData: SingleDataSet = [30, 50, 20];
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartPlugins = [];



}
