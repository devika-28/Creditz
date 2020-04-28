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

    return this.http.post("http://localhost:9999/api/save_analyst",user);
   }


   findAllAnalyst(): Observable<any>{
     return this.http.get("http://localhost:9999/getAllAnalyst");
            
   }
   checkUniqueEmail( userEmail:any): Observable<any>{
        let params = new HttpParams()
        .set('userEmail',userEmail);
        return this.http.get("http://localhost:9999/checkUniqueUser",{params});
            
   }
}