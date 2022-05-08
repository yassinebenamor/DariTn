import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ContratLocationService {

  readonly API_URL="http://localhost:8081/daritn/contratlocation";
  constructor(private httpClient : HttpClient) { }
  getAllContrat(){
    return this.httpClient.get(`${this.API_URL}/`)
  }
  getAllContratByUser(iduser:any){
    return this.httpClient.get(`${this.API_URL}/contratbyuser?id=${iduser}`)
  }
  AddContrat(Contrat : any){
    return this.httpClient.post(`${this.API_URL}/savecontratL`,Contrat)
  }
  EditContrat(Contrat : any){
    return this.httpClient.put(`${this.API_URL}/updateContratL`,Contrat)
  }
  DeleteContrat(idContrat:any){
    return this.httpClient.delete(`${this.API_URL}/deleteContratL/?id=${idContrat}`)
  }
  Tri(){
    return this.httpClient.get(`${this.API_URL}/orderbyetatdate`)
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
