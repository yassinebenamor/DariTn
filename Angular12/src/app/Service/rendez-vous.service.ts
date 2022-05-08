import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RendezVousService {
  readonly API_URL="http://localhost:8081/daritn/rdv";
  constructor(private httpClient : HttpClient) { }
  getAllRendezVous(){
    return this.httpClient.get(`${this.API_URL}/`)
  }
  getAllRendezVousByUser(iduser:any){
    return this.httpClient.get(`${this.API_URL}/getbyuser/?iduser=${iduser}`)
  }
  AddRendezVous(rdv : any){
    return this.httpClient.post(`${this.API_URL}/saverdv`,rdv)
  }
  EditRendezVous(rdv : any){
    return this.httpClient.put(`${this.API_URL}/updaterdv`,rdv)
  }
  DeleteRendezVous(idrdv:any){
    return this.httpClient.delete(`${this.API_URL}/deleterdv/?id=${idrdv}`)
  }
  TodayRendezVous(iduser:any)
  {
    return this.httpClient.get(`${this.API_URL}/today/?userid=${iduser}`)
  }
  RechercheCritere(region:any,etat:any,iduser:any)
  {
    return this.httpClient.get(`${this.API_URL}/r?region=${region}&etat=${etat}&id=${iduser}`)
  }
  Validate(id:any)
  {
    return this.httpClient.put(`${this.API_URL}/validate?id=${id}`,[]);
  }
  Refuse(id:any)
  {
    return this.httpClient.put(`${this.API_URL}/refuse?id=${id}`,[]);
  }
}
