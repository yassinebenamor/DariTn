import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LocationComponent } from './Component/backoffice/location/location.component';
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NgbModalModule, NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { ContratLocationComponent } from './Component/backoffice/contrat-location/contrat-location.component';
import { RendezVousComponent } from './Component/backoffice/rendez-vous/rendez-vous.component';
import { MenuComponent } from './menu/menu.component';
import { FrontComponent } from './front/front.component';
import {RendezvousComponent} from "./Component/frontoffice/rendezvous/rendezvous.component";
import { ContratDeLocationComponent } from './Component/frontoffice/contrat-de-location/contrat-de-location.component';
import { LocationFrontComponent } from './Component/frontoffice/location-front/location-front.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import {ChartsModule} from "ng2-charts";
import { DashboardComponent } from './dashboard/dashboard.component';
import {NgxPaginationModule} from "ngx-pagination";
import { DepotComponent } from './Component/backoffice/depot/depot.component';
import {NgToastModule} from "ng-angular-popup";
import { DepotPdfComponent } from './depot-pdf/depot-pdf.component';

@NgModule({
  declarations: [
    AppComponent,
    LocationComponent,
    ContratLocationComponent,
    RendezVousComponent,
    MenuComponent,
    FrontComponent,
    RendezvousComponent,
    ContratLocationComponent,
    ContratDeLocationComponent,
    LocationFrontComponent,
    FileUploadComponent,
    DashboardComponent,
    DepotComponent,
    DepotPdfComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    NgbModule,
    NgbModalModule,
    ChartsModule,
    NgxPaginationModule,
    NgToastModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
