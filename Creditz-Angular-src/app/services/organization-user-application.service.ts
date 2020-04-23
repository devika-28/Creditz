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
 
  applyService(pancard: string, loanAmount: number, revenue: number, employeeCount: number, businessAge: number, licenseNumber: string, organizationType: string, criminalRecord: number,bankruptcy:number,loanTenure:number, applicationModel: import("../model/organizationapplicant").OrganizationApplicant) {
   console.log(licenseNumber);
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
       "loanTenure":loanAmount,
       "userId":{
       "userId": window.sessionStorage.getItem('userId')
       }
    }

      return this.http.post(this.apiUrl,body,this.config)
        .subscribe(
          (res:Response)=>{
            this.applicationId = res['Application_Id'];
          //console.log(this.applicationId);
            window.open("successful","_self");
            window.alert("Thanks!\nYour Application is not taken into consideration\nEnter valid pan number");
          }
        )
      }
}
