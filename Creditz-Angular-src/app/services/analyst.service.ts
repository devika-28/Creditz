import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import { User } from '../model/user';
@Injectable(
    {
    providedIn: 'root'
    }
)
export class AnalystService {
    constructor(private http:HttpClient) {
     }
registerAnalyst(user:User): Observable<any> {
    console.log("hello");
     return this.http.post("http://localhost:9999/api/save_analyst",user);
    }

}