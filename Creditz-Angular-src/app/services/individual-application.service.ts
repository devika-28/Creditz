import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IndividualApplicationService {

  private apiUrl= "http://localhost:9999/individual-user/user-application";
  private config = { headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8') };
  applicationId: any;
  constructor(private http: HttpClient) { }

  
  applyService(age: number, bankruptcy: number, criminalRecord: number, gender: String, loanAmount: number, loanTenure: number, occupation: String, pancard: String) {

    const body = {
        "pancard": pancard,
        "loanAmount": loanAmount, 
        "age" : age, 
        "gender": gender, 
        "occupation": occupation, 
        "criminalRecord": criminalRecord,
        "bankruptcy":  bankruptcy,
        "loanTenure": loanTenure,
        "userId":{
        "userId": window.sessionStorage.getItem('userId')
      }
    }

    return this.http.post(this.apiUrl,body,this.config)
    .subscribe(
      (res:Response)=>{
        this.applicationId = res['Application_Id'];
        if (res['Application_Id']!=null){
        window.open("successful","_self");
            window.alert("Thanks!\nYour Application is being taken into consideration\nWe will inform you Soon\nYour Application Id is: "+ this.applicationId);
          }
        }
        )
       
  }
}

