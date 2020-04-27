import { Component, OnInit } from '@angular/core';
import { OrganizationApplicant } from '../model/organizationapplicant';
import { Organization } from '../model/organization';
import { OrganizationUserApplicationService } from '../services/organization-user-application.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';



@Component({
  selector: 'app-organizational-user',
  templateUrl: './organizational-user.component.html',
  styleUrls: ['./organizational-user.component.css']
})

export class OrganizationalUserComponent implements OnInit {
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  selected = 'None';
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  isEditable = false;
  isThisStepDone = false;
  // applicationModel = new OrganizationApplicant("", 0, 0,0,0, "", '', "",0,0 , 0);
  
  constructor(private applicationService: OrganizationUserApplicationService,
                 private _formBuilder: FormBuilder ) {
    // document.body.style.backgroundColor="white";
  }
  
  ngOnInit(): void{ this.firstFormGroup = this._formBuilder.group({
    pancard: ['', Validators.required],
    loanAmount: ['', Validators.required],
    revenue:['', Validators.required],
    employeeCount:['', Validators.required],
    businessAge:['', Validators.required],
    licenseNumber:  ['', Validators.required],  
    loanTenure: ['', Validators.required],
    organizationType :['', Validators.required],
  });
  this.secondFormGroup = this._formBuilder.group({
    
    bankruptcy: ['', Validators.required],
    criminalRecord:['', Validators.required]
  });
}
  
  apply(){
    
    window.alert("We will use the information submitted by you at the registration as your contact details");
    console.log(this.selected);
    this.applicationService.applyService(
      this.firstFormGroup.controls['pancard'].value,
      this.firstFormGroup.controls['loanAmount'].value,
      this.firstFormGroup.controls['revenue'].value,
      this.firstFormGroup.controls['employeeCount'].value,
     this.firstFormGroup.controls['businessAge'].value,
     this.firstFormGroup.controls['licenseNumber'].value,
     this.selected,
     this.secondFormGroup.controls['criminalRecord'].value,
     this.secondFormGroup.controls['bankruptcy'].value,
    this.firstFormGroup.controls['loanTenure'].value);      
      
 }
}
