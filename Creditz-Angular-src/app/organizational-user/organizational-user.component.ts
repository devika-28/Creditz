import { Component, OnInit } from '@angular/core';
import { OrganizationApplicant } from '../model/organizationapplicant';
import { Organization } from '../model/organization';
import { OrganizationUserApplicationService } from '../services/organization-user-application.service';

@Component({
  selector: 'app-organizational-user',
  templateUrl: './organizational-user.component.html',
  styleUrls: ['./organizational-user.component.css']
})
export class OrganizationalUserComponent implements OnInit {
  City: any = ['Not registered', 'one person company', 'Partnership', 'Limited company','pvt. ltd.']
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  
  applicationModel = new OrganizationApplicant("", 0, 0,0,0, "", "Type of organization", "",0,0 , 0);
  

  constructor(private applicationService: OrganizationUserApplicationService) {
    document.body.style.backgroundColor="white";
   }

  ngOnInit(): void{}
  

  apply(){
    window.alert("We will use the information submitted by you at the registration as your contact details");
    console.log(this.applicationModel.bankruptcy);

    this.applicationService.applyService(this.applicationModel.pancard,this.applicationModel.loanAmount,this.applicationModel.revenue,this.applicationModel.employeeCount,this.applicationModel.businessAge,this.applicationModel.licenseNumber,this.applicationModel.organizationType,this.applicationModel.criminalRecord,this.applicationModel.bankruptcy,this.applicationModel.loanTenure,this.applicationModel);
  }


}
