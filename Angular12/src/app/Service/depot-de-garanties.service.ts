import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DepotDeGarantiesService {

  readonly API_URL="http://localhost:8081/daritn/DepotDeGaranties";
  constructor(private httpClient : HttpClient) { }
  AddDepot(Depot:any,caution:any){
    return this.httpClient.post(`${this.API_URL}/saveDepot`,[Depot,caution])
  }
  UpdateDepot(Depot:any,caution:any){
    return this.httpClient.post(`${this.API_URL}/updateDepot`,  [Depot,caution])
  }
  DeleteDepot(id:any){
    return this.httpClient.post(`${this.API_URL}/deleteDepot`, id)
  }
  getDepot(){
    return this.httpClient.get(`${this.API_URL}/`)
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
