import {Injectable} from "@angular/core";
import {HttpClient, HttpParams, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import { User } from '../model/user';
@Injectable(
    {
    providedIn: 'root'
    }
)
export class OtpService {
    constructor(private http:HttpClient) {
    }
    
  sendOtpToUser(userEmail:any): Observable<any>
   {
        let params = new HttpParams()
        .set('userEmail',userEmail);
        return this.http.get("http://localhost:9999/getOtp",{params});
   }
}