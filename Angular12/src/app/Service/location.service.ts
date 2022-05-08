import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  readonly API_URL="http://localhost:8081/daritn/location";
  constructor(private httpClient : HttpClient) { }
  getAllLocation(){
    return this.httpClient.get(`${this.API_URL}/`)
  }
  AddLocation(Location : any){
    return this.httpClient.post(`${this.API_URL}/saveLocation`,Location)
  }
  EditLocation(Location : any){
    return this.httpClient.put(`${this.API_URL}/updateLocation`,Location)
  }
  DeleteLocation(idLocation:any){
    return this.httpClient.delete(`${this.API_URL}/deleteLocation/?id=${idLocation}`)
  }
  Stat()
  {
    return this.httpClient.get(`${this.API_URL}/stat`)
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
