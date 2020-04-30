import { OrganizationService } from './../services/organization.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user';
import { Person } from '../model/person';
import { Organization } from '../model/organization';
import { RegistrationService } from '../services/registration.service';
import { NgIf } from '@angular/common';
import { stringToKeyValue } from '@angular/flex-layout/extended/typings/style/style-transforms';
import { ThrowStmt } from '@angular/compiler';
import { AnalystService } from '../services/analyst.service';
import { variable } from '@angular/compiler/src/output/output_ast';
import { MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  hasEmailverified=false;
  enterotp=false;
  emailid:string;
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
  error: string;
  loading: false;
  UserEmailCheck: any;
  otpno: any;
  store = window.sessionStorage.getItem('userId');
  storeRole = window.sessionStorage.getItem('role');
  constructor(
    public dialog: MatDialog,
    private analystService:AnalystService,
    private formBuilder: FormBuilder,
    private router: Router,
    private _registerService:RegistrationService) {}

  ngOnInit() {}

  emailAlreadyExist="";
  emailCheckUnique1(){
    this.analystService.checkUniqueEmail(this.userModel1.userEmail).subscribe(res=>{
    this.UserEmailCheck=res;
    if(this.UserEmailCheck!=null){
      this.emailAlreadyExist="Email Already Exist";
    }
    else{
      this.emailAlreadyExist="";
    }
    });
  }

  emailCheckUnique2(){
    this.analystService.checkUniqueEmail(this.userModel2.userEmail).subscribe(res=>{
    this.UserEmailCheck=res;
    if(this.UserEmailCheck!=null){
      this.emailAlreadyExist="Email Already Exist";
    }
    else{
      this.emailAlreadyExist="";
    }
    });
  }

  sendVerificationEmail(email){
    window.alert("We are sending an OTP to your Email, to verify this really is you!");
    this.emailid=email;
    this._registerService.sendotp(email).subscribe(data=>{
    this.otpno=data;
    if(this.otpno!=null){
    window.alert("Please check your email!");
    this.enterotp=true;
    }
    },
    error => {
      this.error = error;
      window.alert("We are facing some issues in sending OTP, please make sure you have entered correct email id!");
    });
  }

  checkotp(otp){
    if(this.otpno==otp){
      this.hasEmailverified=true;
      this.enterotp=false;
    }
    else{
      window.alert("Please, Enter correct OTP");
    }
  }

  onSubmit1() {
    this.submitted = true;
    this.personModel.user=this.userModel1;
    this._registerService.registerPerson(this.personModel)
    .subscribe( 
      data => {
        window.alert("Voila! You have registered successfully!!!")
        this.router.navigate(['/login'], { queryParams: { registered: true }});
      },
      error => {
        this.error = error;
        this.loading = false;
      }
    );
  }

  onSubmit2() {
    this.submitted = true;
    this.organizationModel.user=this.userModel2;
    this._registerService.registerOrganization(this.organizationModel)
    .subscribe( 
    data => { 
      window.alert("Voila! You have registered successfully!!!");
      this.router.navigate(['/login'], { queryParams: { registered: true }});
    },
    error => {
      this.error = error;
      this.loading = false;
    });
  }

  validateRole1(value){
    if(value=='default'){
      this.topicHasError1=true;
    }
    else{
      this.topicHasError1=false;
    }
  }
 
  validateRole2(value){
    if(value=='default'){
      this.topicHasError2=true;
    }
    else{
      this.topicHasError2=false;
    }
  }

  goToUrl(url: any){
    window.open(url,"_self");
  }
}  