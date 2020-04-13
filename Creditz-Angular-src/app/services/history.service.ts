import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { History} from '../model/history'
import { hostViewClassName } from '@angular/compiler';
import { database } from 'firebase';
@Injectable({
  providedIn: 'root'
})
export class HistoryService {
  history: History[];
  role=window.sessionStorage.getItem('role');
  showHistory(userId: String)  {

    const body = {'userId':{'userId':userId}}

    const config = { headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8') };

if(this.role=='Organization'){
  return this.http.post("http://localhost:9999/organization-user/user-history/",body,config)
}
if(this.role=='Person'){
    return this.http.post("http://localhost:9999/individual-user/user-history/",body,config)
}
}

  constructor( private http: HttpClient) {  }
}