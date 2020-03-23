import { OrganizationService } from './../services/organization.service';

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user';
import { Person } from '../model/person';
import { Organization } from '../model/organization';
import { RegistrationService } from '../services/registration.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']

 
})
export class RegisterComponent implements OnInit {
  roles1 = ['Person' ];
  roles2=['Organization'];
  registerForm: FormGroup;
  submitted = false;

  topicHasError1=true;
  topicHasError2=true;
  
  userModel1=new User(1,'a@gmail.com','empty','default');
  userModel2=new User(1,'a@gmail.com','empty','default');
  personModel=new Person(1,'shiv','678989238','sagar',this.userModel1);
  organizationModel=new Organization(1,'A','435665','bhopal','A.K.Rao',this.userModel2);
  constructor(private formBuilder: FormBuilder, private _registerService:RegistrationService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      cpwd: ['', Validators.required]
  }, {
      validator: this.MustMatch('pwd', 'cpwd')
  });
}


onSubmit1() {
  this.submitted = true;

  console.log(this.personModel)
  console.log(this.userModel1)
   this.personModel.user=this.userModel1;
  this._registerService.registerPerson(this.personModel)
  .subscribe( 
    data=>console.log('success'!,data),
    error=>console.error('Error!',error)
    
   )
}


onSubmit2() {
  this.submitted = true;

  console.log(this.organizationModel)
  console.log(this.userModel2)
   this.organizationModel.user=this.userModel2;
  this._registerService.registerOrganization(this.organizationModel)
  .subscribe( 
    data=>console.log('success'!,data),
    error=>console.error('Error!',error)
 )
}


validateRole1(value){
 if(value=='default'){
   this.topicHasError1=true;
 }else{
   this.topicHasError1=false;
 }
}
 
validateRole2(value){
  if(value=='default'){
    this.topicHasError2=true;
  }else{
    this.topicHasError2=false;
  }
 }
    MustMatch(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
        const control = formGroup.controls[controlName];
        const matchingControl = formGroup.controls[matchingControlName];

        if (matchingControl.errors && !matchingControl.errors.mustMatch) {
            // return if another validator has already found an error on the matchingControl
            return;
        }

        // set error on matchingControl if validation fails
        if (control.value !== matchingControl.value) {
            matchingControl.setErrors({ mustMatch: true });
        } else {
            matchingControl.setErrors(null);
        }
    }
}

goToUrl(url: any){
  window.open(url,"_self");
}
  
}


