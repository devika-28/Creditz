import { Component, OnInit } from '@angular/core';
import { IndividualApplication } from '../model/individual-application'
import { IndividualApplicationService } from '../services/individual-application.service'

@Component({
  selector: 'app-individual-user-application',
  templateUrl: './individual-user-application.component.html',
  styleUrls: ['../individual-user/individual-user.component.css']
})
export class IndividualUserApplicationComponent implements OnInit {

  applicationModel = new IndividualApplication("", 0, 0, "", "", 0, 0, 0);
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');

  constructor(private applicationService: IndividualApplicationService) { }

  ngOnInit(): void {
  }

  apply(){
    window.alert("We will use the information submitted by you at the registration as your contact details");
    this.applicationService.applyService(this.applicationModel.age,this.applicationModel.bankruptcy,this.applicationModel.criminalRecord,this.applicationModel.gender,this.applicationModel.loanAmount,this.applicationModel.loanTenure,this.applicationModel.occupation,this.applicationModel.pancard,this.applicationModel);
  }

}
