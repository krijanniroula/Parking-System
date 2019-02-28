import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Records } from './records.model';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  url: string = "https://parkingsystemapi.cfapps.io/api/";

  constructor(private http:HttpClient) { }

  getRecords(){
    return this.http.get(this.url+'records');
  }

  getRecordsById(id:number){
    return this.http.get(this.url+'records/'+id);
  }

  public createRecords(data : Records){
    return this.http.post(this.url+'records',data);
  }

  public updateRecords(data : Records){
    return this.http.put(this.url+'records/'+data.id,data);
  }

  public deleteRecords(id : number){
    return this.http.delete(this.url+'records/'+id);
  }

}
