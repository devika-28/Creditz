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


   findAllAnalyst(pageNo: any ,pageSize: any): Observable<any>{
       const params = new HttpParams()
       .set('pageNo', pageNo+"")
       .append('pageSize', pageSize+"");
       return this.http.get("http://localhost:9999/getAllAnalyst",{params});
            
   }
   checkUniqueEmail( userEmail:any): Observable<any>{
        let params = new HttpParams()
        .set('userEmail',userEmail);
        return this.http.get("http://localhost:9999/checkUniqueUser",{params});
            
   }
}