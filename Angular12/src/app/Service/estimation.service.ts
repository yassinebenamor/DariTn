import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EstimationService {

  constructor(private httpClient : HttpClient) { }
  GetEstimation(estimation:any){
    return this.httpClient.post(`http://localhost:8081/daritn/Estimation/`,estimation)
  }
}
