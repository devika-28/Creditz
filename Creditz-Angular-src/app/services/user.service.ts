import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

   deleteAnalyst(userEmail:any):Observable<any>{
      console.log(userEmail);
      let params = new HttpParams()
     .set('userEmail',userEmail);
      console.log(params);
      return this.http.delete("http://localhost:9999/deleteAnalyst",{params});
    }
}
