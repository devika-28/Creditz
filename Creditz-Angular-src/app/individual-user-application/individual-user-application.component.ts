import { Component, OnInit } from '@angular/core';
import { IndividualApplication } from '../model/individual-application'
import { IndividualApplicationService } from '../services/individual-application.service'
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatStepper } from '@angular/material/stepper';

@Component({
  selector: 'app-individual-user-application',
  templateUrl: './individual-user-application.component.html',
  styleUrls: ['../forgot-password/forgot-password.component.css']
})
export class IndividualUserApplicationComponent implements OnInit {

  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  minAmount=10000;
  maxAmount=1500000;
  minTenure=3;
  maxTenure=100;

  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  isEditable = false;
  isThisStepDone = false;
  constructor(private applicationService: IndividualApplicationService,
    private _formBuilder: FormBuilder) { }

    ngOnInit() {
      this.firstFormGroup = this._formBuilder.group({
        pancard: ['', Validators.required],
        loanAmount: ['', [Validators.required, Validators.min(this.minAmount), Validators.max(this.maxAmount)]],
        age: ['', Validators.required],
        occupation: ['', Validators.required],
        loanTenure: ['', [Validators.required,  Validators.min(this.minTenure), Validators.max(this.maxTenure)]]
      });
      this.secondFormGroup = this._formBuilder.group({
        gender: ['', Validators.required],
        bankruptcy: ['', Validators.required],
        criminalRecord:['', Validators.required]
      });
    }

  apply(){
    window.alert("We will use the information submitted by you during the registration as your contact details");
    this.applicationService.applyService(this.firstFormGroup.controls['age'].value,
    this.secondFormGroup.controls['bankruptcy'].value,
    this.secondFormGroup.controls['criminalRecord'].value,
    this.secondFormGroup.controls['gender'].value,
    this.firstFormGroup.controls['loanAmount'].value,
    this.firstFormGroup.controls['loanTenure'].value,
    this.firstFormGroup.controls['occupation'].value,
    this.firstFormGroup.controls['pancard'].value);
  }

}
