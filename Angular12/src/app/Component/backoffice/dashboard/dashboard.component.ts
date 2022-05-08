import {Component, OnInit} from '@angular/core';
import { ChartType, ChartOptions } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';
import { ContratachatService } from '../../../Service/contratachat.service';
import {Observable} from "rxjs"
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  arr : Number[] =[];
  public PieChartOptions: ChartOptions = {
    responsive: true,
  };
  constructor(private ContratachatService : ContratachatService) {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }
  ngOnInit()
  {
    this.getStat();
    console.log(this.PieChartData());
  }
  public PieChartLabels: Label[] = [['Waiting'], ['Confirmed'], 'Refused'];
  public PieChartData:any;
  public PieChartType: ChartType = 'pie';
  public PieChartLegend = true;
  public PieChartPlugins = [];
  private getStat() {
    this.ContratachatService.Stat().subscribe((res) =>this.PieChartData = res);
  }

}
