import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class OrganizationUserApplicationService {
  private apiUrl= "http://localhost:9999/organization-user/user-application";
  private config = { headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8') };
  applicationId: any;
  constructor(private http: HttpClient) { }
 
  applyService(pancard: string, loanAmount: number, revenue: number, employeeCount: number, businessAge: number, licenseNumber: string, organizationType: string, criminalRecord: number,bankruptcy:number,loanTenure:number) {
    const body = {
       "pancard": pancard,
       "loanAmount": loanAmount,
       "revenue": revenue,
       "employeeCount": employeeCount,
       "businessAge": businessAge, 
       "licenseNumber": licenseNumber,
       "organizationType": organizationType,
       "criminalRecord": criminalRecord,
       "bankruptcy":bankruptcy,
       "loanTenure":loanTenure,
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
