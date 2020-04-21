import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  // BASE_PATH: 'http://localhost:9999'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public username: String;
  public password: String;

  goToUrl(url: string){
    window.open(url,"_self");
}

 constructor(private http: HttpClient) {

  }

  authenticationService(username: String, password: String) {
    return this.http.get(`http://localhost:9999/login/`,
    { headers: {
      Authorization: this.createBasicAuthToken(username, password) ,
     } 
            })
    .pipe(map((res) => {
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
                  this.goToUrl('organization-user-calculator');
                   break; 
                } 
                case 'Admin': { 
                  this.goToUrl('adminsidenav');
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
    }))

  }

  createBasicAuthToken(username: String, password: String) {
    console.log('Basic ' + window.btoa(username + ":" + password))
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.username = null;
    this.password = null;
  }
}