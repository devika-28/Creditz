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
  
  showHistory(userId: String)  {

    const body = {'userId':{'userId':userId}}

    const config = { headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8') };

    return this.http.post("http://localhost:9999/individual-user/user-history/",body,config)
}

  constructor( private http: HttpClient) {  }
}
