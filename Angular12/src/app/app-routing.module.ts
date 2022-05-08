import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContratLocationComponent } from './Component/backoffice/contrat-location/contrat-location.component';
import { RendezVousComponent } from './Component/backoffice/rendez-vous/rendez-vous.component';
import { LocationComponent } from './Component/backoffice/location/location.component';
import { MenuComponent } from './menu/menu.component';
import {FrontComponent} from "./front/front.component";
import {RendezvousComponent} from "./Component/frontoffice/rendezvous/rendezvous.component";
import { ContratDeLocationComponent } from './Component/frontoffice/contrat-de-location/contrat-de-location.component';
import {DashboardComponent} from "./dashboard/dashboard.component";
import {DepotComponent} from "./Component/backoffice/depot/depot.component";
import {DepotPdfComponent} from "./depot-pdf/depot-pdf.component";

const routes: Routes = [
  { path:'',component:MenuComponent , children:[
      {path:'',component:DashboardComponent},
      {path:'location',component:LocationComponent},
      {path:'contratlocation',component:ContratLocationComponent},
      {path:'rendezvous',component:RendezVousComponent},
      {path:'depot',component:DepotComponent},
  ]},
  {path:'depotpdf',component:DepotPdfComponent},
  {path:'front',component:FrontComponent},
  {path:'rdv',component:RendezvousComponent},
  {path:'ctlocation',component:ContratDeLocationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
