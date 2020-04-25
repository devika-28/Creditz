import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError, map } from 'rxjs/operators';

import { Login } from '../model/login';
import { FindValueSubscriber } from 'rxjs/internal/operators/find';
import { KeyValuePipe } from '@angular/common';
import { Key } from 'protractor';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrl= "http://localhost:9999";
  private config = { headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8') };


  constructor( private http: HttpClient) {  }

goToUrl(url: string){
    window.open(url,"_self");
}

 login(userEmail: String, password: String) {
    const body = {'userEmail': userEmail, 'password': password};
      
      return this.http.post(this.apiUrl+'/login',body,this.config)
                .subscribe(
                  
                  (res: Response)=> {  

                    if (res['userId']==null){
                      // console.log("INVALID USERID");
                      // this.goToUrl('home');
                      alert("Invalid Credentials");

                      }

                    else{

                      try{
                      console.log(res['role']);
                      
                      window.sessionStorage.setItem("userId",res['userId']);
                      console.log(res['userId']);
                      window.sessionStorage.setItem("role",res['role']);


                      switch(res['role']) { 
                        case 'Person': { 
                          this.goToUrl('individual-user');
                          break; 
                        } 
                        case 'Organization': { 
                          this.goToUrl('organization-policy');
                           break; 
                        } 
                        case 'Admin': { 
                          this.goToUrl('admin');
                          break; 
                       } 
                       case 'Analyst': { 
                        this.goToUrl('financial-analyst');
                        break; 
                     } 
                        default: { 
                          this.goToUrl('home');
                           break; 
                        } 
                     } 
                    }
                    catch(Error){
                      console.log(Error.message)
                      alert("Sorry Cant log you in in the moment, it is not you it is us!")
                    }
                    



                   }
                  },
                (err: HttpErrorResponse) => {
                      if (err.error instanceof Error) {
                              console.log('Client-side error occured.');
                              alert("Sorry Cant log you in in the moment, it is not you it is us!")

                      } else {
                              console.log('Server-side error occured.');
                              alert("Sorry Cant log you in in the moment, it is not you it is us!")

                      }
                });
     
    }

    logout(){
      window.sessionStorage.removeItem('userId');
    }

  }