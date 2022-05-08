import {Component, OnInit} from '@angular/core';
import { ChartType, ChartOptions } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';
import {LocationService} from "../Service/location.service";
import {Observable} from "rxjs"


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{

  arr : Number[] =[];
  public pieChartOptions: ChartOptions = {
    responsive: true,
  };
  constructor(private LocationService : LocationService) {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }
  ngOnInit()
  {
    this.getStat();
    console.log(this.pieChartData());
  }
  public pieChartLabels: Label[] = [['Vacances'], ['Temporraire'], 'Temporraire','Long Period'];
  public pieChartData:any;
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartPlugins = [];
  private getStat() {
    this.LocationService.Stat().subscribe((res) =>this.pieChartData = res);
  }


}
